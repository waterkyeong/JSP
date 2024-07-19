package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class FileUtil {
	//파일 업로드
	public static String uploadFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException { //파일 업로드위한 메서트
		Part part =req.getPart("ofile");//file타입으로 전송된 폼값을 받아 part객체를 생성
		String partHeader = part.getHeader("content-disposition");	//part 객체의 헤더값을 읽어와서 원본 파일명을 추출
		String[] phArr = partHeader.split("filename="); //헤더값에서 파일명 잘라내기
		String originalFileName = phArr[1].trim().replace("\"", ""); //["파일명.jpg"] > [파일명.jpg]
		if(!originalFileName.isEmpty()) {
			part.write(sDirectory + File.separator +originalFileName);
		}
		return originalFileName;
	}
	
	//파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
	}
	
	//multiple 속성 추가로 2개 이상의 파일 업로드
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		ArrayList<String> listFileName = new ArrayList<>();
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			if(!part.getName().equals("ofile")) continue;
			
			String partHeader = part.getHeader("content-disposition");
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if(!originalFileName.isEmpty()) {
				part.write(sDirectory + File.separator+ originalFileName);
			}
			listFileName.add(originalFileName);
		}
		return listFileName;
	}
	
	//명시한 파일을 찾아 다운로드합니다.
	public static void download(HttpServletRequest req, HttpServletResponse resp, String directory, String sfileName, String ofileName) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		try {
			//파일을 찾아 입력 스트림 생성
			File file = new File(sDirectory, sfileName);
			InputStream iStream = new FileInputStream(file);
			
			//한글 파일명 깨짐 방지
			String client = req.getHeader("User-Agent");
			if(client.indexOf("WOW64") == -1) {
				ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
			}else {
				ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
			}
			
			//파일 다운로드용 응답 헤더 설정
			resp.reset();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename=\""+ofileName+"\"");
			resp.setHeader("Content-Length", ""+file.length());
			
			//out.clear(); //출력 스트림 초기화
			
			//response 내장 객체로부터 새로운 출력 스트림 생성
			OutputStream oStream = resp.getOutputStream();
			
			//출력 스트림에 파일 내용 출력
			byte b[]= new byte[(int)file.length()];
			int readBuffer =0;
			while((readBuffer = iStream.read(b))>0) {
				oStream.write(b,0,readBuffer);
			}
			
			//입/출력 스트림 닫음
			iStream.close();
			oStream.close();
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	//지정한 위치의 파일을 삭제합니다.
	public static void deleteFile(HttpServletRequest req, String directory, String filename) {
		String sDirectory = req.getServletContext().getRealPath(directory);	//파일이 저장된 물리적 경로 얻어오기
		File file = new File(sDirectory+File.separator+filename);	//물리적 경로와 파일명을 결합하여 파일객체 생성
		if(file.exists()) {	//파일이 존재하면
			file.delete();	//파일 삭제
		}
		
	}
}

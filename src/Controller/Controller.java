package Controller;

import Model.UserDAO;
import Model.UserDTO;

public class Controller {

   private UserDAO userDAO;

   public Controller() {
      userDAO = new UserDAO();
   }

   // 회원가입 메서드
   public void addUser(UserDTO dto) {
      UserDAO dao = new UserDAO();
      dao.dbOpen();
      int cnt = dao.addUser(dto);
      
      if(cnt > 0) {
         System.out.println("회원 등록 성공!");
         
      } else {
         System.out.println("회원 등록 실패!");
      }
   }

   // 로그인 메서드
   public int login(String id, String password) {
      return userDAO.login(id, password);
   }
   
}

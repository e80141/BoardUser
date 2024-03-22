package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private  MenuMapper  menuMapper;
	
	// 메뉴 목록 조회  /Menus/List
	@RequestMapping("/List")   
	public   String   list( Model model ) {
		// 조회한결과를 ArrayList 로 돌려준디
		List<MenuVo> menuList = menuMapper.getMenuList();
				
		// 조회 결과를 넘겨준다 ( Model )
		model.addAttribute( "menuList", menuList );
		System.out.println( "MenuController list() menuList:" + menuList );
		
		return "menus/list";
	}
	
	
	
	
	// 메뉴 입력받는 화면  /Menus/WriteForm
	//@RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")   // /Menus/WriteForm
	public   String   writeForm() {
		return "menus/write";  // /WEB-INF/views/ + menus/write + .jsp`
	}
		
	
	
	// 메뉴 저장
	// /Menus/Write?menu_id=MENU02&menu_name=JSP&menu_seq=2
	//@RequestMapping("/Menus/Write")
	@RequestMapping("/Write")  
	//public   String   write( 
	// 		String menu_id, String menu_name, int menu_seq) { 
	 // 인식안됨(error)     menu_id 를 찾을 수 없다
	public   String   write( MenuVo  menuVo ) {   // Vo 로 작업해야한다
		// 넘어온 데이터를 db 에 저장하고		
		menuMapper.insertMenu( menuVo );
		// menuMapper.insertMenu(menu_id, menu_name, menu_seq); // error
		
		return "menus/list";    // menus/list.jsp  
	}
	// /Menus/WriteForm2
	@RequestMapping("/WriteForm2")
	public String writeForm2() {
		return"menus/write2.jsp";
	}
	
	@RequestMapping("/Write2")
    public String Write2(MenuVo menuVo) {
		//저장
		menuMapper.insertMenuByName(menuVo);
		//조회로 이동
		 return"redirect:/Menus/List";
	}
	
	
	
	
	// 메뉴삭제 /Menus/Delete?menu_id=Menu03
	//@RequestMapping("/Delete")
	//public String delete(MenuVo menuVo) {
		//Menu03 을 삭제
		
		//menuMapper.deleteMenu(menuVo);
		//이동할 파일
		//return "menus/list";

	
//MENU 수정
///Menus/UpdateForm?menu_id=$
@RequestMapping("/Menus/UpdateForm")
public String updateForm(MenuVo menuVo) {
	
	
	return"menus/update";
}

// /Menus/Update
@RequestMapping("/Update")
public String update(MenuVo menuVo) {
	
	//수정
	menuMapper.updateMenu()
	
	// 수정 후 조회
	return "redirect:/Menus/List";
	
}
}





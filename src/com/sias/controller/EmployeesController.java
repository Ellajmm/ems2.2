package com.sias.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;
import com.sias.service.EmployeesService;

@Controller
@RequestMapping("/emp")
public class EmployeesController{
	@Autowired
	private EmployeesService employeesService;
	
	
	//id��ѯ
	@RequestMapping("/showEmpl.do")
	public String showEmpl(Model model,String id){
		Employees empl = employeesService.queryEmpl(id);//����
		List<Departments> depList = employeesService.queryDep();
		model.addAttribute("empl",empl);
		model.addAttribute("depList", depList);
		return "updateEmp"; //�޸�jsp
	}
	//��ҳ������
	@RequestMapping("/showEmp.do")
	public String showEmp(Model model,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Employees> emps = employeesService.queryAll(pb);
		model.addAttribute("emps", emps);
		model.addAttribute("pb", pb);
		return "emplist";  // emplist.jsp
	}
	
	//ɾ��
	@RequestMapping("/delEmp.do")
	public String delEmp(String id){
		employeesService.delEmpl(id);
		return "redirect:/emp/showEmp.do"; //������action
	}

	//�޸�
	@RequestMapping("/updEmp.do")
	public String updEmp(Employees employee){
		employeesService.updEmpl(employee);
		return "redirect:/emp/showEmp.do"; //������action
	}
	
	//���Ż���
	@RequestMapping("/showDep.do")
	public String showDep(Model model){
		List<Departments> depList = employeesService.queryDep();
		model.addAttribute("depList",depList);
		return "addEmp";
	}
	
	//���Ա��
	@RequestMapping("/addEmp.do")
	public String addEmp(Employees employee){
		employeesService.insertEmpl(employee);
		return "redirect:/emp/showEmp.do"; //������action
	}
	
	//��nameģ����ѯ
	@RequestMapping("/querySomEmp.do")
	public String querySomEmp(HttpSession session,Model model,String str){
		List<Employees> emps = employeesService.querySomeEmps(str);
		model.addAttribute("emps", emps);
		session.setAttribute("session.str", str);
		return "emplist"; //����ת����תjsp
	}
	
	//����ɾ��
	@RequestMapping("/delSomEmp.do")
	public String delSomEmp(@RequestParam List<String> listIds){
		employeesService.deltEmps(listIds);
		return "redirect:/emp/showEmp.do"; //������action
	}
 	
	
}

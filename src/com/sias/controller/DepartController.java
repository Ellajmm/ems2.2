package com.sias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sias.entity.Departments;
import com.sias.entity.Employees;
import com.sias.entity.PageBean;
import com.sias.service.DepartService;

@Controller
@RequestMapping("/dep")
public class DepartController {
	@Autowired
	private DepartService departService;
	
	//��ҳչʾ���в���
	@RequestMapping("/showDep.do")
	public String showDep(Model model,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Departments> deps = departService.queryAllDep(pb);
		model.addAttribute("deps",deps);
		model.addAttribute("pb", pb);
		return "deptlist";  //չʾjsp
	}
	
	//��ҳչʾͬһ����������Ա��
	@RequestMapping("/detilDep.do")
	public String detilDep(Model model,String id,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Employees> dep = departService.queryEmp(id, pb);
		model.addAttribute("emps",dep);
		model.addAttribute("pb", pb);
		return "emplist"; //չʾͬһ����Ա��
	}
	
	//��ȡ��Ҫ�޸ĵ���Ҫ��Ϣ
	@RequestMapping("/showThis.do")
	public String showThis(Model model,String id){
		Departments dep = departService.queryBid(id);  //id��ѯthis
		//List<Departments> deps = departService.findDeps(); //���в�����Ϣ
		model.addAttribute("dep", dep);
		//model.addAttribute("deps", deps);
		return "updDep";
	}
	
	//�޸Ĳ�����Ϣ
	@RequestMapping("/updDep.do")
	public String updDep(Departments departments){
		departService.updateDep(departments);
		return "redirect:/dep/showDep.do"; 
	}
	
	//��Ӳ���
	@RequestMapping("/addDep.do")
	public String addDept(Departments departments){
			departService.addDep(departments);
			return "redirect:/dep/showDep.do";
	  }
	
	//ģ����ѯ�� ���֣�
	@RequestMapping("/showSome.do")
    public String showSome(Model model,String str,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Departments> dep = departService.querySomeDep(str, pb);
		model.addAttribute("deps",dep);
		model.addAttribute("pb", pb);
    	return "deptlist";
    }
	
}

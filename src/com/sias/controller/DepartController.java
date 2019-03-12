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
	
	//分页展示所有部门
	@RequestMapping("/showDep.do")
	public String showDep(Model model,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Departments> deps = departService.queryAllDep(pb);
		model.addAttribute("deps",deps);
		model.addAttribute("pb", pb);
		return "deptlist";  //展示jsp
	}
	
	//分页展示同一部门下所有员工
	@RequestMapping("/detilDep.do")
	public String detilDep(Model model,String id,@RequestParam(defaultValue="1")Integer pageNo){
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		List<Employees> dep = departService.queryEmp(id, pb);
		model.addAttribute("emps",dep);
		model.addAttribute("pb", pb);
		return "emplist"; //展示同一部门员工
	}
	
	//获取想要修改的需要信息
	@RequestMapping("/showThis.do")
	public String showThis(Model model,String id){
		Departments dep = departService.queryBid(id);  //id查询this
		//List<Departments> deps = departService.findDeps(); //所有部门信息
		model.addAttribute("dep", dep);
		//model.addAttribute("deps", deps);
		return "updDep";
	}
	
	//修改部门信息
	@RequestMapping("/updDep.do")
	public String updDep(Departments departments){
		departService.updateDep(departments);
		return "redirect:/dep/showDep.do"; 
	}
	
	//添加部门
	@RequestMapping("/addDep.do")
	public String addDept(Departments departments){
			departService.addDep(departments);
			return "redirect:/dep/showDep.do";
	  }
	
	//模糊查询（ 名字）
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

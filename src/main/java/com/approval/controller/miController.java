package com.approval.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.approval.service.approvalService;
import com.approval.vo.Employee;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

@Controller
public class miController {
	
	@Resource(name="approvalService")
	private approvalService approvalService;
	
	//리스트
	@RequestMapping(value="get2")
	public void get2(HttpServletResponse response) throws Exception{
	  
	VariableList out_vl = new VariableList();
	DatasetList  out_dl = new DatasetList();
	   
	List<Employee> list = approvalService.milist();
	 	  	  
	out_vl.addStr("ErrorCode", "0");
	out_vl.addStr("ErrorMsg", "SUCC");
	 	  
	Dataset ds = new Dataset("milist");
	 
	ds.addColumn("EMPSEQ",ColumnInfo.CY_COLINFO_INT, 20);
	ds.addColumn("EMPNAME",ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("EMPGRADE",ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("EMPID",ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("EMPPW",ColumnInfo.CY_COLINFO_STRING, 20);
	 	 		 
	for(Employee emp : list){
		int row = ds.appendRow();
	 	ds.setColumn(row,"EMPSEQ",emp.getEMPSEQ());	
	 	ds.setColumn(row,"EMPNAME",emp.getEMPNAME());
	 	ds.setColumn(row,"EMPGRADE", emp.getEMPGRADE());
	 	ds.setColumn(row,"EMPID", emp.getEMPID());
	 	ds.setColumn(row,"EMPPW", emp.getEMPPW());
	}
	 
	out_dl.addDataset(ds); 
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");	 
	pRes.sendData(out_vl, out_dl);	  
	}	
	
	
	/*** 
	  입력
	 **/
	@RequestMapping(value="getlist")
	public void get1(HttpServletResponse response,HttpServletRequest request) throws Exception{
	
	VariableList in_vl = new VariableList();
	DatasetList  in_dl = new DatasetList();	
	PlatformRequest pReq = new PlatformRequest(request, "utf-8");
		     
	pReq.receiveData();
	
	in_vl = pReq.getVariableList();
	in_dl = pReq.getDatasetList();
	
	Dataset ds = in_dl.getDataset("milist");
	
	Employee list = new Employee();
	
	ds.getRowCount();
	for(int i=0;i<ds.getRowCount();i++){
		list.setEMPNAME(ds.getColumn(i, "EMPNAME").toString());
		list.setEMPGRADE(ds.getColumn(i, "EMPGRADE").toString());
		list.setEMPID(ds.getColumn(i, "EMPID").toString());
		list.setEMPPW(ds.getColumn(i, "EMPPW").toString());
	}
			 
	int cnt = approvalService.setlistmi(list);
	
	VariableList out_vl = new VariableList();
	DatasetList  out_dl = new DatasetList();
	
	List<Employee> getlist = approvalService.milist();
 	  
	out_vl.addStr("ErrorCode", "0");
	out_vl.addStr("ErrorMsg", "SUCC");
	 	  
	Dataset dss = new Dataset("migetlist");
	 
	dss.addColumn("EMPSEQ",ColumnInfo.CY_COLINFO_INT, 20);
	dss.addColumn("EMPNAME",ColumnInfo.CY_COLINFO_STRING, 20);
	dss.addColumn("EMPGRADE",ColumnInfo.CY_COLINFO_STRING, 20);
	dss.addColumn("EMPID",ColumnInfo.CY_COLINFO_STRING, 20);
	dss.addColumn("EMPPW",ColumnInfo.CY_COLINFO_STRING, 20);
	 	 		 
	for(Employee emp : getlist){
		int row = ds.appendRow();
		dss.setColumn(row,"EMPSEQ",emp.getEMPSEQ());	
		dss.setColumn(row,"EMPNAME",emp.getEMPNAME());
		dss.setColumn(row,"EMPGRADE", emp.getEMPGRADE());
		dss.setColumn(row,"EMPID", emp.getEMPID());
		dss.setColumn(row,"EMPPW", emp.getEMPPW());
	}
	 
	out_dl.addDataset(dss); 
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");	 
	pRes.sendData(out_vl, out_dl);	  
	}	
	
		
		
	
	
	
	
	  	 
}
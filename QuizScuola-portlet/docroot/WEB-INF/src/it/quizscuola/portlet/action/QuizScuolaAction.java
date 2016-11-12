package it.quizscuola.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.quizscuola.portlet.service.ClasseServiceUtil;

public class QuizScuolaAction extends MVCPortlet {

	
	public void editClasse(ActionRequest req,ActionResponse resp){
		try{
			String cmd = ParamUtil.getString(req, Constants.CMD);
			ServiceContext ctx = ServiceContextFactory.getInstance(req);
			if(cmd.equals(Constants.ADD)){
		
			}else if(cmd.equals(Constants.UPDATE)){
				
			}
		}catch(Exception ex){
			
		}
	}
}

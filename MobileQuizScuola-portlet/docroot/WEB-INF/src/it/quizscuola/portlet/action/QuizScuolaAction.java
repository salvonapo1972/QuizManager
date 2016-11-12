package it.quizscuola.portlet.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.taglib.aui.FieldWrapperTag;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.model.impl.RispostaImpl;
import it.quizscuola.portlet.service.ArgomentoServiceUtil;
import it.quizscuola.portlet.service.ClasseServiceUtil;
import it.quizscuola.portlet.service.DomandaLocalService;
import it.quizscuola.portlet.service.DomandaServiceUtil;
import it.quizscuola.portlet.service.MateriaServiceUtil;
import it.quizscuola.portlet.service.RispostaLocalServiceUtil;
import it.quizscuola.portlet.service.RispostaService;
import it.quizscuola.portlet.service.RispostaServiceUtil;

public class QuizScuolaAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(QuizScuolaAction.class);
	private static final String pageViewMateria = "/html/quiz/viewMateria.jsp";
	private static final String pageViewDomanda = "/html/quiz/viewDomanda.jsp";
	private static final String pageEditDomanda = "/html/quiz/editDomanda.jsp";
	private static final String pageEditMateria = "/html/quiz/editMateria.jsp";
	private static final String pageEditArgomento = "/html/quiz/editArgomento.jsp";
	private static final String pageViewClass = "/html/quiz/view.jsp";
	private static final String pageViewArgomento = "/html/quiz/viewArgomento.jsp";
	
	public void editClasse(ActionRequest req,ActionResponse resp){
		try{
			String cmd = ParamUtil.getString(req, Constants.CMD);
			String descClasse = ParamUtil.getString(req, "descClasse");
			ServiceContext ctx = ServiceContextFactory.getInstance(req);
			if(cmd.equals(Constants.ADD)){
		          ClasseServiceUtil.addClasse(ctx, descClasse);
			}else if(cmd.equals(Constants.UPDATE)){
				long idClasse = ParamUtil.getLong(req, "idClasse");
				ClasseServiceUtil.updateClasse(idClasse, descClasse);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-edit-classe");
			PortalUtil.copyRequestParameters(req, resp);
		}
	}
	
	public void deleteClasse(ActionRequest req,ActionResponse resp){
		try{
			
			long id = ParamUtil.getLong(req,"id");
		    ClasseServiceUtil.removeClasse(id);
			
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-remove");
		}finally{
			resp.setRenderParameter("mvcPath", pageViewClass);
		}
	}
	
	public void editMateria(ActionRequest req,ActionResponse resp){
		try{
			String cmd = ParamUtil.getString(req, Constants.CMD);
			String descMateria = ParamUtil.getString(req, "descMateria");
			
			ServiceContext ctx = ServiceContextFactory.getInstance(req);
			if(cmd.equals(Constants.ADD)){
				  String idClasse = ParamUtil.getString(req, "idClasse");
		          MateriaServiceUtil.addMateria(ctx, descMateria,Long.valueOf(idClasse));
			}else if(cmd.equals(Constants.UPDATE)){
				long idMateria = ParamUtil.getLong(req, "idMateria");
				MateriaServiceUtil.updateMateria(idMateria, descMateria);
			}
			resp.setRenderParameter("mvcPath", pageViewMateria);
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-edit-materia");
			
			resp.setRenderParameter("mvcPath", pageEditMateria);
		}
		PortalUtil.copyRequestParameters(req, resp);
		
	}
	
	
	public void editArgomento(ActionRequest req,ActionResponse resp){
		try{
			String cmd = ParamUtil.getString(req, Constants.CMD);
			String descArgomento = ParamUtil.getString(req, "descArgomento");
			
			ServiceContext ctx = ServiceContextFactory.getInstance(req);
			if(cmd.equals(Constants.ADD)){
				  String idMateria = ParamUtil.getString(req, "idMateria");
		          ArgomentoServiceUtil.addArgomento(ctx, descArgomento, Long.valueOf(idMateria));
			}else if(cmd.equals(Constants.UPDATE)){
				long idArgomento = ParamUtil.getLong(req, "idArgomento");
				ArgomentoServiceUtil.updateArgomento(idArgomento, descArgomento);
			}
			resp.setRenderParameter("mvcPath", pageViewArgomento);
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-edit-materia");
			PortalUtil.copyRequestParameters(req, resp);
			resp.setRenderParameter("mvcPath", pageEditArgomento);
		}
		PortalUtil.copyRequestParameters(req, resp);
		
	}
	
	public void deleteMateria(ActionRequest req,ActionResponse resp){
		try{
			
			long id = ParamUtil.getLong(req,"id");
			MateriaServiceUtil.deleteMateriaByIdMateria(id);
			resp.setRenderParameter("mvcPath", pageViewMateria);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			resp.setRenderParameter("mvcPath", pageViewMateria);
		}
	}
	
	public void deleteArgomento(ActionRequest req,ActionResponse resp){
		try{
			
			long id = ParamUtil.getLong(req,"idArgomento");
			//ArgomentoServiceUtil.removeArgomento(id);
			ArgomentoServiceUtil.deleteDomandasERisposteByArgomento(id);
			resp.setRenderParameter("mvcPath", pageViewArgomento);
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-remove");
			resp.setRenderParameter("mvcPath", pageEditArgomento);
		}finally{
			PortalUtil.copyRequestParameters(req, resp);
			//resp.setRenderParameter("mvcPath", pageViewArgomento);
		}
	}
	
	public void deleteDomanda(ActionRequest req,ActionResponse resp) throws PortalException, SystemException{
		long idDomanda = ParamUtil.getLong(req,"idDomanda");
		System.out.println("passo");
		try{
		    DomandaServiceUtil.deleteDomanda(idDomanda);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			resp.setRenderParameter("mvcPath", pageViewDomanda);
			PortalUtil.copyRequestParameters(req, resp);
		}
	}
	
	public void editDomanda(ActionRequest req,ActionResponse resp){
		try{
			String responseIndexesString = req.getParameter("responseIndexes");
			String domanda = ParamUtil.getString(req,"domanda");
			String cmd = ParamUtil.getString(req,"cmd");
			long idArgomento = ParamUtil.getLong(req,"idArgomento");
			
			
			//System.out.println("=============phonesIndexesString=="+responseIndexesString);
			int[] responseIndexes = StringUtil.split(responseIndexesString, 0);
	        ServiceContext ctx = ServiceContextFactory.getInstance(req);
	        List<Risposta> listaRisposte = new ArrayList<Risposta>();
			for (int responseIndex : responseIndexes) {
				Risposta risposta = new RispostaImpl();
				if(cmd.equals(Constants.UPDATE)){
					long fieldIdRisposta = ParamUtil.getLong(req, "fieldHidden" + responseIndex);
					if(Validator.isNull(fieldIdRisposta)){
						fieldIdRisposta = CounterLocalServiceUtil.increment(Risposta.class.getName());
					}
					risposta.setIdRisposta(fieldIdRisposta);
				}
				String fieldTestoRisposta = ParamUtil.getString(req, "field" + responseIndex);
				//System.out.println("field:" + fieldTestoRisposta);
				String fieldEsatta = ParamUtil.getString(req, "fieldTypeId" + responseIndex);
				//System.out.println("fieldEsatta:" + fieldEsatta);
				if(Validator.isNull(fieldEsatta)){
					fieldEsatta="false";
				}
				risposta.setDescRisposta(fieldTestoRisposta);
				risposta.setEsatta(Boolean.valueOf(fieldEsatta));
				listaRisposte.add(risposta);
			}
			//Dopo aver composto la lista controllo se update se è stato eliminato qualche record
			
			
			if(cmd.equals(Constants.ADD)){
				DomandaServiceUtil.addDomanda(ctx, domanda, idArgomento, listaRisposte);
			}else{//update
				long idDomanda = ParamUtil.getLong(req,"idDomanda");
				List<Risposta> rispostas = RispostaLocalServiceUtil.getRispostas(idDomanda);
				for(Risposta risposta : rispostas){
					if(!listaRisposte.contains(risposta)){
						RispostaLocalServiceUtil.deleteRisposta(risposta);
					}
				}
				DomandaServiceUtil.updateDomanda(ctx,idDomanda, domanda, idArgomento, listaRisposte);
			}
			resp.setRenderParameter("mvcPath", pageViewDomanda);
		}catch(Exception ex){
			ex.printStackTrace();
			SessionErrors.add(req, "error-edit-domanda");
			
			resp.setRenderParameter("mvcPath", pageEditDomanda);
		}finally{
			PortalUtil.copyRequestParameters(req, resp);
		}
		
	}
}

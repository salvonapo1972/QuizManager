/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.quizscuola.portlet.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.quizscuola.portlet.model.ArgomentoClp;
import it.quizscuola.portlet.model.ClasseClp;
import it.quizscuola.portlet.model.DomandaClp;
import it.quizscuola.portlet.model.MateriaClp;
import it.quizscuola.portlet.model.RispostaClp;
import it.quizscuola.portlet.model.RispostaUtenteClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salvatore
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"QuizScuola-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"QuizScuola-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "QuizScuola-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ArgomentoClp.class.getName())) {
			return translateInputArgomento(oldModel);
		}

		if (oldModelClassName.equals(ClasseClp.class.getName())) {
			return translateInputClasse(oldModel);
		}

		if (oldModelClassName.equals(DomandaClp.class.getName())) {
			return translateInputDomanda(oldModel);
		}

		if (oldModelClassName.equals(MateriaClp.class.getName())) {
			return translateInputMateria(oldModel);
		}

		if (oldModelClassName.equals(RispostaClp.class.getName())) {
			return translateInputRisposta(oldModel);
		}

		if (oldModelClassName.equals(RispostaUtenteClp.class.getName())) {
			return translateInputRispostaUtente(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputArgomento(BaseModel<?> oldModel) {
		ArgomentoClp oldClpModel = (ArgomentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getArgomentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputClasse(BaseModel<?> oldModel) {
		ClasseClp oldClpModel = (ClasseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getClasseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDomanda(BaseModel<?> oldModel) {
		DomandaClp oldClpModel = (DomandaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDomandaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMateria(BaseModel<?> oldModel) {
		MateriaClp oldClpModel = (MateriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMateriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRisposta(BaseModel<?> oldModel) {
		RispostaClp oldClpModel = (RispostaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRispostaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRispostaUtente(BaseModel<?> oldModel) {
		RispostaUtenteClp oldClpModel = (RispostaUtenteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRispostaUtenteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.ArgomentoImpl")) {
			return translateOutputArgomento(oldModel);
		}

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.ClasseImpl")) {
			return translateOutputClasse(oldModel);
		}

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.DomandaImpl")) {
			return translateOutputDomanda(oldModel);
		}

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.MateriaImpl")) {
			return translateOutputMateria(oldModel);
		}

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.RispostaImpl")) {
			return translateOutputRisposta(oldModel);
		}

		if (oldModelClassName.equals(
					"it.quizscuola.portlet.model.impl.RispostaUtenteImpl")) {
			return translateOutputRispostaUtente(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("it.quizscuola.portlet.NoSuchArgomentoException")) {
			return new it.quizscuola.portlet.NoSuchArgomentoException();
		}

		if (className.equals("it.quizscuola.portlet.NoSuchClasseException")) {
			return new it.quizscuola.portlet.NoSuchClasseException();
		}

		if (className.equals("it.quizscuola.portlet.NoSuchDomandaException")) {
			return new it.quizscuola.portlet.NoSuchDomandaException();
		}

		if (className.equals("it.quizscuola.portlet.NoSuchMateriaException")) {
			return new it.quizscuola.portlet.NoSuchMateriaException();
		}

		if (className.equals("it.quizscuola.portlet.NoSuchRispostaException")) {
			return new it.quizscuola.portlet.NoSuchRispostaException();
		}

		if (className.equals(
					"it.quizscuola.portlet.NoSuchRispostaUtenteException")) {
			return new it.quizscuola.portlet.NoSuchRispostaUtenteException();
		}

		return throwable;
	}

	public static Object translateOutputArgomento(BaseModel<?> oldModel) {
		ArgomentoClp newModel = new ArgomentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setArgomentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputClasse(BaseModel<?> oldModel) {
		ClasseClp newModel = new ClasseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setClasseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDomanda(BaseModel<?> oldModel) {
		DomandaClp newModel = new DomandaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDomandaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMateria(BaseModel<?> oldModel) {
		MateriaClp newModel = new MateriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMateriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRisposta(BaseModel<?> oldModel) {
		RispostaClp newModel = new RispostaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRispostaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRispostaUtente(BaseModel<?> oldModel) {
		RispostaUtenteClp newModel = new RispostaUtenteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRispostaUtenteRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}
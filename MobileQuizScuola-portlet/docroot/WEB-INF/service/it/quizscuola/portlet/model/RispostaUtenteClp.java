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

package it.quizscuola.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.quizscuola.portlet.service.ClpSerializer;
import it.quizscuola.portlet.service.RispostaUtenteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Salvatore
 */
public class RispostaUtenteClp extends BaseModelImpl<RispostaUtente>
	implements RispostaUtente {
	public RispostaUtenteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RispostaUtente.class;
	}

	@Override
	public String getModelClassName() {
		return RispostaUtente.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _idRispostaUtente;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdRispostaUtente(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idRispostaUtente;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idRispostaUtente", getIdRispostaUtente());
		attributes.put("idRisposta", getIdRisposta());
		attributes.put("idUtente", getIdUtente());
		attributes.put("dataRisposta", getDataRisposta());
		attributes.put("idDomanda", getIdDomanda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long idRispostaUtente = (Long)attributes.get("idRispostaUtente");

		if (idRispostaUtente != null) {
			setIdRispostaUtente(idRispostaUtente);
		}

		Long idRisposta = (Long)attributes.get("idRisposta");

		if (idRisposta != null) {
			setIdRisposta(idRisposta);
		}

		Long idUtente = (Long)attributes.get("idUtente");

		if (idUtente != null) {
			setIdUtente(idUtente);
		}

		Date dataRisposta = (Date)attributes.get("dataRisposta");

		if (dataRisposta != null) {
			setDataRisposta(dataRisposta);
		}

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rispostaUtenteRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdRispostaUtente() {
		return _idRispostaUtente;
	}

	@Override
	public void setIdRispostaUtente(long idRispostaUtente) {
		_idRispostaUtente = idRispostaUtente;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setIdRispostaUtente",
						long.class);

				method.invoke(_rispostaUtenteRemoteModel, idRispostaUtente);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdRisposta() {
		return _idRisposta;
	}

	@Override
	public void setIdRisposta(long idRisposta) {
		_idRisposta = idRisposta;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setIdRisposta", long.class);

				method.invoke(_rispostaUtenteRemoteModel, idRisposta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdUtente() {
		return _idUtente;
	}

	@Override
	public void setIdUtente(long idUtente) {
		_idUtente = idUtente;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setIdUtente", long.class);

				method.invoke(_rispostaUtenteRemoteModel, idUtente);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataRisposta() {
		return _dataRisposta;
	}

	@Override
	public void setDataRisposta(Date dataRisposta) {
		_dataRisposta = dataRisposta;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setDataRisposta", Date.class);

				method.invoke(_rispostaUtenteRemoteModel, dataRisposta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdDomanda() {
		return _idDomanda;
	}

	@Override
	public void setIdDomanda(long idDomanda) {
		_idDomanda = idDomanda;

		if (_rispostaUtenteRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaUtenteRemoteModel.getClass();

				Method method = clazz.getMethod("setIdDomanda", long.class);

				method.invoke(_rispostaUtenteRemoteModel, idDomanda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRispostaUtenteRemoteModel() {
		return _rispostaUtenteRemoteModel;
	}

	public void setRispostaUtenteRemoteModel(
		BaseModel<?> rispostaUtenteRemoteModel) {
		_rispostaUtenteRemoteModel = rispostaUtenteRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _rispostaUtenteRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_rispostaUtenteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RispostaUtenteLocalServiceUtil.addRispostaUtente(this);
		}
		else {
			RispostaUtenteLocalServiceUtil.updateRispostaUtente(this);
		}
	}

	@Override
	public RispostaUtente toEscapedModel() {
		return (RispostaUtente)ProxyUtil.newProxyInstance(RispostaUtente.class.getClassLoader(),
			new Class[] { RispostaUtente.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RispostaUtenteClp clone = new RispostaUtenteClp();

		clone.setUuid(getUuid());
		clone.setIdRispostaUtente(getIdRispostaUtente());
		clone.setIdRisposta(getIdRisposta());
		clone.setIdUtente(getIdUtente());
		clone.setDataRisposta(getDataRisposta());
		clone.setIdDomanda(getIdDomanda());

		return clone;
	}

	@Override
	public int compareTo(RispostaUtente rispostaUtente) {
		int value = 0;

		if (getIdDomanda() < rispostaUtente.getIdDomanda()) {
			value = -1;
		}
		else if (getIdDomanda() > rispostaUtente.getIdDomanda()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RispostaUtenteClp)) {
			return false;
		}

		RispostaUtenteClp rispostaUtente = (RispostaUtenteClp)obj;

		long primaryKey = rispostaUtente.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", idRispostaUtente=");
		sb.append(getIdRispostaUtente());
		sb.append(", idRisposta=");
		sb.append(getIdRisposta());
		sb.append(", idUtente=");
		sb.append(getIdUtente());
		sb.append(", dataRisposta=");
		sb.append(getDataRisposta());
		sb.append(", idDomanda=");
		sb.append(getIdDomanda());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("it.quizscuola.portlet.model.RispostaUtente");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idRispostaUtente</column-name><column-value><![CDATA[");
		sb.append(getIdRispostaUtente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idRisposta</column-name><column-value><![CDATA[");
		sb.append(getIdRisposta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idUtente</column-name><column-value><![CDATA[");
		sb.append(getIdUtente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataRisposta</column-name><column-value><![CDATA[");
		sb.append(getDataRisposta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDomanda</column-name><column-value><![CDATA[");
		sb.append(getIdDomanda());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _idRispostaUtente;
	private long _idRisposta;
	private long _idUtente;
	private Date _dataRisposta;
	private long _idDomanda;
	private BaseModel<?> _rispostaUtenteRemoteModel;
}
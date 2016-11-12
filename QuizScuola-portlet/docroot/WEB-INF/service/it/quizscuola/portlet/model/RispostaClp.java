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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.quizscuola.portlet.service.ClpSerializer;
import it.quizscuola.portlet.service.RispostaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Salvatore
 */
public class RispostaClp extends BaseModelImpl<Risposta> implements Risposta {
	public RispostaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Risposta.class;
	}

	@Override
	public String getModelClassName() {
		return Risposta.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _idRisposta;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdRisposta(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idRisposta;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idRisposta", getIdRisposta());
		attributes.put("descRisposta", getDescRisposta());
		attributes.put("posizione", getPosizione());
		attributes.put("esatta", getEsatta());
		attributes.put("idDomanda", getIdDomanda());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long idRisposta = (Long)attributes.get("idRisposta");

		if (idRisposta != null) {
			setIdRisposta(idRisposta);
		}

		String descRisposta = (String)attributes.get("descRisposta");

		if (descRisposta != null) {
			setDescRisposta(descRisposta);
		}

		Integer posizione = (Integer)attributes.get("posizione");

		if (posizione != null) {
			setPosizione(posizione);
		}

		Boolean esatta = (Boolean)attributes.get("esatta");

		if (esatta != null) {
			setEsatta(esatta);
		}

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rispostaRemoteModel, uuid);
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

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdRisposta", long.class);

				method.invoke(_rispostaRemoteModel, idRisposta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescRisposta() {
		return _descRisposta;
	}

	@Override
	public void setDescRisposta(String descRisposta) {
		_descRisposta = descRisposta;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescRisposta", String.class);

				method.invoke(_rispostaRemoteModel, descRisposta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPosizione() {
		return _posizione;
	}

	@Override
	public void setPosizione(int posizione) {
		_posizione = posizione;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setPosizione", int.class);

				method.invoke(_rispostaRemoteModel, posizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEsatta() {
		return _esatta;
	}

	@Override
	public boolean isEsatta() {
		return _esatta;
	}

	@Override
	public void setEsatta(boolean esatta) {
		_esatta = esatta;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setEsatta", boolean.class);

				method.invoke(_rispostaRemoteModel, esatta);
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

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdDomanda", long.class);

				method.invoke(_rispostaRemoteModel, idDomanda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rispostaRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rispostaRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rispostaRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rispostaRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rispostaRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_rispostaRemoteModel != null) {
			try {
				Class<?> clazz = _rispostaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rispostaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Risposta.class.getName()));
	}

	public BaseModel<?> getRispostaRemoteModel() {
		return _rispostaRemoteModel;
	}

	public void setRispostaRemoteModel(BaseModel<?> rispostaRemoteModel) {
		_rispostaRemoteModel = rispostaRemoteModel;
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

		Class<?> remoteModelClass = _rispostaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rispostaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RispostaLocalServiceUtil.addRisposta(this);
		}
		else {
			RispostaLocalServiceUtil.updateRisposta(this);
		}
	}

	@Override
	public Risposta toEscapedModel() {
		return (Risposta)ProxyUtil.newProxyInstance(Risposta.class.getClassLoader(),
			new Class[] { Risposta.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RispostaClp clone = new RispostaClp();

		clone.setUuid(getUuid());
		clone.setIdRisposta(getIdRisposta());
		clone.setDescRisposta(getDescRisposta());
		clone.setPosizione(getPosizione());
		clone.setEsatta(getEsatta());
		clone.setIdDomanda(getIdDomanda());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Risposta risposta) {
		int value = 0;

		if (getPosizione() < risposta.getPosizione()) {
			value = -1;
		}
		else if (getPosizione() > risposta.getPosizione()) {
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

		if (!(obj instanceof RispostaClp)) {
			return false;
		}

		RispostaClp risposta = (RispostaClp)obj;

		long primaryKey = risposta.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", idRisposta=");
		sb.append(getIdRisposta());
		sb.append(", descRisposta=");
		sb.append(getDescRisposta());
		sb.append(", posizione=");
		sb.append(getPosizione());
		sb.append(", esatta=");
		sb.append(getEsatta());
		sb.append(", idDomanda=");
		sb.append(getIdDomanda());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("it.quizscuola.portlet.model.Risposta");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idRisposta</column-name><column-value><![CDATA[");
		sb.append(getIdRisposta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descRisposta</column-name><column-value><![CDATA[");
		sb.append(getDescRisposta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>posizione</column-name><column-value><![CDATA[");
		sb.append(getPosizione());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esatta</column-name><column-value><![CDATA[");
		sb.append(getEsatta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDomanda</column-name><column-value><![CDATA[");
		sb.append(getIdDomanda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _idRisposta;
	private String _descRisposta;
	private int _posizione;
	private boolean _esatta;
	private long _idDomanda;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _rispostaRemoteModel;
}
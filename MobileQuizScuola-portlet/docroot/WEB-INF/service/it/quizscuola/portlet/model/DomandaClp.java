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
import it.quizscuola.portlet.service.DomandaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Salvatore
 */
public class DomandaClp extends BaseModelImpl<Domanda> implements Domanda {
	public DomandaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Domanda.class;
	}

	@Override
	public String getModelClassName() {
		return Domanda.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _idDomanda;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdDomanda(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idDomanda;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idDomanda", getIdDomanda());
		attributes.put("descDomanda", getDescDomanda());
		attributes.put("idArgomento", getIdArgomento());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("posizione", getPosizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
		}

		String descDomanda = (String)attributes.get("descDomanda");

		if (descDomanda != null) {
			setDescDomanda(descDomanda);
		}

		Long idArgomento = (Long)attributes.get("idArgomento");

		if (idArgomento != null) {
			setIdArgomento(idArgomento);
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

		Integer posizione = (Integer)attributes.get("posizione");

		if (posizione != null) {
			setPosizione(posizione);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_domandaRemoteModel, uuid);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdDomanda", long.class);

				method.invoke(_domandaRemoteModel, idDomanda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescDomanda() {
		return _descDomanda;
	}

	@Override
	public void setDescDomanda(String descDomanda) {
		_descDomanda = descDomanda;

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescDomanda", String.class);

				method.invoke(_domandaRemoteModel, descDomanda);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdArgomento() {
		return _idArgomento;
	}

	@Override
	public void setIdArgomento(long idArgomento) {
		_idArgomento = idArgomento;

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdArgomento", long.class);

				method.invoke(_domandaRemoteModel, idArgomento);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_domandaRemoteModel, groupId);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_domandaRemoteModel, companyId);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_domandaRemoteModel, userId);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_domandaRemoteModel, userName);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_domandaRemoteModel, createDate);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_domandaRemoteModel, modifiedDate);
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

		if (_domandaRemoteModel != null) {
			try {
				Class<?> clazz = _domandaRemoteModel.getClass();

				Method method = clazz.getMethod("setPosizione", int.class);

				method.invoke(_domandaRemoteModel, posizione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Domanda.class.getName()));
	}

	public BaseModel<?> getDomandaRemoteModel() {
		return _domandaRemoteModel;
	}

	public void setDomandaRemoteModel(BaseModel<?> domandaRemoteModel) {
		_domandaRemoteModel = domandaRemoteModel;
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

		Class<?> remoteModelClass = _domandaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_domandaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DomandaLocalServiceUtil.addDomanda(this);
		}
		else {
			DomandaLocalServiceUtil.updateDomanda(this);
		}
	}

	@Override
	public Domanda toEscapedModel() {
		return (Domanda)ProxyUtil.newProxyInstance(Domanda.class.getClassLoader(),
			new Class[] { Domanda.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DomandaClp clone = new DomandaClp();

		clone.setUuid(getUuid());
		clone.setIdDomanda(getIdDomanda());
		clone.setDescDomanda(getDescDomanda());
		clone.setIdArgomento(getIdArgomento());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPosizione(getPosizione());

		return clone;
	}

	@Override
	public int compareTo(Domanda domanda) {
		int value = 0;

		if (getPosizione() < domanda.getPosizione()) {
			value = -1;
		}
		else if (getPosizione() > domanda.getPosizione()) {
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

		if (!(obj instanceof DomandaClp)) {
			return false;
		}

		DomandaClp domanda = (DomandaClp)obj;

		long primaryKey = domanda.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", idDomanda=");
		sb.append(getIdDomanda());
		sb.append(", descDomanda=");
		sb.append(getDescDomanda());
		sb.append(", idArgomento=");
		sb.append(getIdArgomento());
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
		sb.append(", posizione=");
		sb.append(getPosizione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.quizscuola.portlet.model.Domanda");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDomanda</column-name><column-value><![CDATA[");
		sb.append(getIdDomanda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descDomanda</column-name><column-value><![CDATA[");
		sb.append(getDescDomanda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idArgomento</column-name><column-value><![CDATA[");
		sb.append(getIdArgomento());
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
		sb.append(
			"<column><column-name>posizione</column-name><column-value><![CDATA[");
		sb.append(getPosizione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _idDomanda;
	private String _descDomanda;
	private long _idArgomento;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _posizione;
	private BaseModel<?> _domandaRemoteModel;
}
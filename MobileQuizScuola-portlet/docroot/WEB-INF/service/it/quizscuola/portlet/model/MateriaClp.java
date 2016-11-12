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
import it.quizscuola.portlet.service.MateriaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Salvatore
 */
public class MateriaClp extends BaseModelImpl<Materia> implements Materia {
	public MateriaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Materia.class;
	}

	@Override
	public String getModelClassName() {
		return Materia.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _idMateria;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdMateria(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idMateria;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idMateria", getIdMateria());
		attributes.put("descMateria", getDescMateria());
		attributes.put("idClasse", getIdClasse());
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

		Long idMateria = (Long)attributes.get("idMateria");

		if (idMateria != null) {
			setIdMateria(idMateria);
		}

		String descMateria = (String)attributes.get("descMateria");

		if (descMateria != null) {
			setDescMateria(descMateria);
		}

		Long idClasse = (Long)attributes.get("idClasse");

		if (idClasse != null) {
			setIdClasse(idClasse);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_materiaRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdMateria() {
		return _idMateria;
	}

	@Override
	public void setIdMateria(long idMateria) {
		_idMateria = idMateria;

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdMateria", long.class);

				method.invoke(_materiaRemoteModel, idMateria);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescMateria() {
		return _descMateria;
	}

	@Override
	public void setDescMateria(String descMateria) {
		_descMateria = descMateria;

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setDescMateria", String.class);

				method.invoke(_materiaRemoteModel, descMateria);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdClasse() {
		return _idClasse;
	}

	@Override
	public void setIdClasse(long idClasse) {
		_idClasse = idClasse;

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setIdClasse", long.class);

				method.invoke(_materiaRemoteModel, idClasse);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_materiaRemoteModel, groupId);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_materiaRemoteModel, companyId);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_materiaRemoteModel, userId);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_materiaRemoteModel, userName);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_materiaRemoteModel, createDate);
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

		if (_materiaRemoteModel != null) {
			try {
				Class<?> clazz = _materiaRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_materiaRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Materia.class.getName()));
	}

	public BaseModel<?> getMateriaRemoteModel() {
		return _materiaRemoteModel;
	}

	public void setMateriaRemoteModel(BaseModel<?> materiaRemoteModel) {
		_materiaRemoteModel = materiaRemoteModel;
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

		Class<?> remoteModelClass = _materiaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_materiaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MateriaLocalServiceUtil.addMateria(this);
		}
		else {
			MateriaLocalServiceUtil.updateMateria(this);
		}
	}

	@Override
	public Materia toEscapedModel() {
		return (Materia)ProxyUtil.newProxyInstance(Materia.class.getClassLoader(),
			new Class[] { Materia.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MateriaClp clone = new MateriaClp();

		clone.setUuid(getUuid());
		clone.setIdMateria(getIdMateria());
		clone.setDescMateria(getDescMateria());
		clone.setIdClasse(getIdClasse());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Materia materia) {
		int value = 0;

		value = getDescMateria().compareTo(materia.getDescMateria());

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

		if (!(obj instanceof MateriaClp)) {
			return false;
		}

		MateriaClp materia = (MateriaClp)obj;

		long primaryKey = materia.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", idMateria=");
		sb.append(getIdMateria());
		sb.append(", descMateria=");
		sb.append(getDescMateria());
		sb.append(", idClasse=");
		sb.append(getIdClasse());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.quizscuola.portlet.model.Materia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idMateria</column-name><column-value><![CDATA[");
		sb.append(getIdMateria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descMateria</column-name><column-value><![CDATA[");
		sb.append(getDescMateria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idClasse</column-name><column-value><![CDATA[");
		sb.append(getIdClasse());
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
	private long _idMateria;
	private String _descMateria;
	private long _idClasse;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _materiaRemoteModel;
}
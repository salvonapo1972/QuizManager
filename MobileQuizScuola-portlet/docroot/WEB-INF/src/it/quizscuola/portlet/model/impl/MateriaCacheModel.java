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

package it.quizscuola.portlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.quizscuola.portlet.model.Materia;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Materia in entity cache.
 *
 * @author Salvatore
 * @see Materia
 * @generated
 */
public class MateriaCacheModel implements CacheModel<Materia>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idMateria=");
		sb.append(idMateria);
		sb.append(", descMateria=");
		sb.append(descMateria);
		sb.append(", idClasse=");
		sb.append(idClasse);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Materia toEntityModel() {
		MateriaImpl materiaImpl = new MateriaImpl();

		if (uuid == null) {
			materiaImpl.setUuid(StringPool.BLANK);
		}
		else {
			materiaImpl.setUuid(uuid);
		}

		materiaImpl.setIdMateria(idMateria);

		if (descMateria == null) {
			materiaImpl.setDescMateria(StringPool.BLANK);
		}
		else {
			materiaImpl.setDescMateria(descMateria);
		}

		materiaImpl.setIdClasse(idClasse);
		materiaImpl.setGroupId(groupId);
		materiaImpl.setCompanyId(companyId);
		materiaImpl.setUserId(userId);

		if (userName == null) {
			materiaImpl.setUserName(StringPool.BLANK);
		}
		else {
			materiaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			materiaImpl.setCreateDate(null);
		}
		else {
			materiaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			materiaImpl.setModifiedDate(null);
		}
		else {
			materiaImpl.setModifiedDate(new Date(modifiedDate));
		}

		materiaImpl.resetOriginalValues();

		return materiaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		idMateria = objectInput.readLong();
		descMateria = objectInput.readUTF();
		idClasse = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(idMateria);

		if (descMateria == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descMateria);
		}

		objectOutput.writeLong(idClasse);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long idMateria;
	public String descMateria;
	public long idClasse;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
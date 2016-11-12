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

package it.quizscuola.portlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.service.DomandaLocalServiceUtil;

/**
 * @author Salvatore
 * @generated
 */
public abstract class DomandaActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public DomandaActionableDynamicQuery() throws SystemException {
		setBaseLocalService(DomandaLocalServiceUtil.getService());
		setClass(Domanda.class);

		setClassLoader(it.quizscuola.portlet.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("idDomanda");
	}
}
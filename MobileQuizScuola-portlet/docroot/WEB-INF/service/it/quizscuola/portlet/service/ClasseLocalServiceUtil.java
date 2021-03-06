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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Classe. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.ClasseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Salvatore
 * @see ClasseLocalService
 * @see it.quizscuola.portlet.service.base.ClasseLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.ClasseLocalServiceImpl
 * @generated
 */
public class ClasseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.ClasseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the classe to the database. Also notifies the appropriate model listeners.
	*
	* @param classe the classe
	* @return the classe that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe addClasse(
		it.quizscuola.portlet.model.Classe classe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addClasse(classe);
	}

	/**
	* Creates a new classe with the primary key. Does not add the classe to the database.
	*
	* @param id the primary key for the new classe
	* @return the new classe
	*/
	public static it.quizscuola.portlet.model.Classe createClasse(long id) {
		return getService().createClasse(id);
	}

	/**
	* Deletes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the classe
	* @return the classe that was removed
	* @throws PortalException if a classe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe deleteClasse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClasse(id);
	}

	/**
	* Deletes the classe from the database. Also notifies the appropriate model listeners.
	*
	* @param classe the classe
	* @return the classe that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe deleteClasse(
		it.quizscuola.portlet.model.Classe classe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteClasse(classe);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ClasseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ClasseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.quizscuola.portlet.model.Classe fetchClasse(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClasse(id);
	}

	/**
	* Returns the classe with the matching UUID and company.
	*
	* @param uuid the classe's UUID
	* @param companyId the primary key of the company
	* @return the matching classe, or <code>null</code> if a matching classe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe fetchClasseByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClasseByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the classe matching the UUID and group.
	*
	* @param uuid the classe's UUID
	* @param groupId the primary key of the group
	* @return the matching classe, or <code>null</code> if a matching classe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe fetchClasseByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchClasseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the classe with the primary key.
	*
	* @param id the primary key of the classe
	* @return the classe
	* @throws PortalException if a classe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe getClasse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasse(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the classe with the matching UUID and company.
	*
	* @param uuid the classe's UUID
	* @param companyId the primary key of the company
	* @return the matching classe
	* @throws PortalException if a matching classe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe getClasseByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasseByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the classe matching the UUID and group.
	*
	* @param uuid the classe's UUID
	* @param groupId the primary key of the group
	* @return the matching classe
	* @throws PortalException if a matching classe could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe getClasseByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasseByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the classes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ClasseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of classes
	* @param end the upper bound of the range of classes (not inclusive)
	* @return the range of classes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Classe> getClasses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasses(start, end);
	}

	/**
	* Returns the number of classes.
	*
	* @return the number of classes
	* @throws SystemException if a system exception occurred
	*/
	public static int getClassesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClassesCount();
	}

	/**
	* Updates the classe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param classe the classe
	* @return the classe that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Classe updateClasse(
		it.quizscuola.portlet.model.Classe classe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateClasse(classe);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static it.quizscuola.portlet.model.Classe addClasse(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descClasse) {
		return getService().addClasse(ctx, descClasse);
	}

	public static it.quizscuola.portlet.model.Classe updateClasse(
		long idClasse, java.lang.String descClasse)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchClasseException {
		return getService().updateClasse(idClasse, descClasse);
	}

	public static java.util.List<it.quizscuola.portlet.model.Classe> getClasses(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getClasses(start, end, orderByComparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static ClasseLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ClasseLocalService.class.getName());

			if (invokableLocalService instanceof ClasseLocalService) {
				_service = (ClasseLocalService)invokableLocalService;
			}
			else {
				_service = new ClasseLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ClasseLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ClasseLocalService service) {
	}

	private static ClasseLocalService _service;
}
/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hibernate.keeper.persister;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MappingException;
import org.hibernate.bytecode.spi.EntityInstrumentationMetadata;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.cache.spi.entry.CacheEntryStructure;
import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.ValueInclusion;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.FilterAliasGenerator;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.hibernate.tuple.entity.EntityTuplizer;
import org.hibernate.type.Type;
import org.hibernate.type.VersionType;

/**
 * @author Serkan ÖZAL
 */
public class HibernateKeeperEntityPersister implements EntityPersister {

	protected EntityPersister delegatedEntityPersister;
	
	public HibernateKeeperEntityPersister(EntityPersister delegatedEntityPersister) {
		this.delegatedEntityPersister = delegatedEntityPersister;
	}
	
	@Override
	public Comparator<?> getVersionComparator() {
		return delegatedEntityPersister.getVersionComparator();
	}

	@Override
	public void postInstantiate() throws MappingException {
		delegatedEntityPersister.postInstantiate();
	}

	@Override
	public SessionFactoryImplementor getFactory() {
		return delegatedEntityPersister.getFactory();
	}

	@Override
	public String getRootEntityName() {
		return delegatedEntityPersister.getRootEntityName();
	}

	@Override
	public String getEntityName() {
		return delegatedEntityPersister.getEntityName();
	}

	@Override
	public EntityMetamodel getEntityMetamodel() {
		return delegatedEntityPersister.getEntityMetamodel();
	}

	@Override
	public boolean isSubclassEntityName(String entityName) {
		return delegatedEntityPersister.isSubclassEntityName(entityName);
	}

	@Override
	public Serializable[] getPropertySpaces() {
		return delegatedEntityPersister.getPropertySpaces();
	}

	@Override
	public Serializable[] getQuerySpaces() {
		return delegatedEntityPersister.getQuerySpaces();
	}

	@Override
	public boolean hasProxy() {
		return delegatedEntityPersister.hasProxy();
	}

	@Override
	public boolean hasCollections() {
		return delegatedEntityPersister.hasCollections();
	}

	@Override
	public boolean hasMutableProperties() {
		return delegatedEntityPersister.hasMutableProperties();
	}

	@Override
	public boolean hasSubselectLoadableCollections() {
		return delegatedEntityPersister.hasSubselectLoadableCollections();
	}

	@Override
	public boolean hasCascades() {
		return delegatedEntityPersister.hasCascades();
	}

	@Override
	public boolean isMutable() {
		return delegatedEntityPersister.isMutable();
	}

	@Override
	public boolean isInherited() {
		return delegatedEntityPersister.isInherited();
	}

	@Override
	public boolean isIdentifierAssignedByInsert() {
		return delegatedEntityPersister.isIdentifierAssignedByInsert();
	}

	@Override
	public Type getPropertyType(String propertyName) throws MappingException {
		return delegatedEntityPersister.getPropertyType(propertyName);
	}

	@Override
	public int[] findDirty(Object[] currentState, Object[] previousState,
			Object owner, SessionImplementor session) {
		return delegatedEntityPersister.findDirty(currentState, previousState, owner, session);
	}

	@Override
	public int[] findModified(Object[] old, Object[] current, Object object,
			SessionImplementor session) {
		return delegatedEntityPersister.findModified(old, current, object, session);
	}

	@Override
	public boolean hasIdentifierProperty() {
		return delegatedEntityPersister.hasIdentifierProperty();
	}

	@Override
	public boolean canExtractIdOutOfEntity() {
		return delegatedEntityPersister.canExtractIdOutOfEntity();
	}

	@Override
	public boolean isVersioned() {
		return delegatedEntityPersister.isVersioned();
	}

	@Override
	public VersionType<?> getVersionType() {
		return delegatedEntityPersister.getVersionType();
	}

	@Override
	public int getVersionProperty() {
		return delegatedEntityPersister.getVersionProperty();
	}

	@Override
	public boolean hasNaturalIdentifier() {
		return delegatedEntityPersister.hasNaturalIdentifier();
	}

	@Override
	public int[] getNaturalIdentifierProperties() {
		return delegatedEntityPersister.getNaturalIdentifierProperties();
	}

	@Override
	public Object[] getNaturalIdentifierSnapshot(Serializable id, SessionImplementor session) {
		return delegatedEntityPersister.getNaturalIdentifierSnapshot(id, session);
	}

	@Override
	public IdentifierGenerator getIdentifierGenerator() {
		return delegatedEntityPersister.getIdentifierGenerator();
	}

	@Override
	public boolean hasLazyProperties() {
		return delegatedEntityPersister.hasLazyProperties();
	}

	@Override
	public Serializable loadEntityIdByNaturalId(Object[] naturalIdValues,
			LockOptions lockOptions, SessionImplementor session) {
		return delegatedEntityPersister.loadEntityIdByNaturalId(naturalIdValues, lockOptions, session);
	}

	@Override
	public Object load(Serializable id, Object optionalObject,
			LockMode lockMode, SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.load(id, optionalObject, lockMode, session);
	}

	@Override
	public Object load(Serializable id, Object optionalObject,
			LockOptions lockOptions, SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.load(id, optionalObject, lockOptions, session);
	}

	@Override
	public void lock(Serializable id, Object version, Object object,
			LockMode lockMode, SessionImplementor session) throws HibernateException {
		delegatedEntityPersister.lock(id, version, object, lockMode, session);
	}

	@Override
	public void lock(Serializable id, Object version, Object object,
			LockOptions lockOptions, SessionImplementor session) throws HibernateException {
		delegatedEntityPersister.lock(id, version, object, lockOptions, session);
	}

	@Override
	public void insert(Serializable id, Object[] fields, Object object,
			SessionImplementor session) throws HibernateException {
		delegatedEntityPersister.insert(id, fields, object, session);
	}

	@Override
	public Serializable insert(Object[] fields, Object object,
			SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.insert(fields, object, session);
	}

	@Override
	public void delete(Serializable id, Object version, Object object,
			SessionImplementor session) throws HibernateException {
		delegatedEntityPersister.delete(id, version, object, session);
	}

	@Override
	public void update(Serializable id, Object[] fields, int[] dirtyFields,
			boolean hasDirtyCollection, Object[] oldFields, Object oldVersion,
			Object object, Object rowId, SessionImplementor session) throws HibernateException {
		delegatedEntityPersister.update(id, fields, dirtyFields, hasDirtyCollection, 
				oldFields, oldVersion, object, rowId, session);
	}

	@Override
	public Type[] getPropertyTypes() {
		return delegatedEntityPersister.getPropertyTypes();
	}

	@Override
	public String[] getPropertyNames() {
		return delegatedEntityPersister.getPropertyNames();
	}

	@Override
	public boolean[] getPropertyInsertability() {
		return delegatedEntityPersister.getPropertyInsertability();
	}

	@Override
	public ValueInclusion[] getPropertyInsertGenerationInclusions() {
		return delegatedEntityPersister.getPropertyInsertGenerationInclusions();
	}

	@Override
	public ValueInclusion[] getPropertyUpdateGenerationInclusions() {
		return delegatedEntityPersister.getPropertyUpdateGenerationInclusions();
	}

	@Override
	public boolean[] getPropertyUpdateability() {
		return delegatedEntityPersister.getPropertyUpdateability();
	}

	@Override
	public boolean[] getPropertyCheckability() {
		return delegatedEntityPersister.getPropertyCheckability();
	}

	@Override
	public boolean[] getPropertyNullability() {
		return delegatedEntityPersister.getPropertyNullability();
	}

	@Override
	public boolean[] getPropertyVersionability() {
		return delegatedEntityPersister.getPropertyVersionability();
	}

	@Override
	public boolean[] getPropertyLaziness() {
		return delegatedEntityPersister.getPropertyLaziness();
	}

	@Override
	public CascadeStyle[] getPropertyCascadeStyles() {
		return delegatedEntityPersister.getPropertyCascadeStyles();
	}

	@Override
	public Type getIdentifierType() {
		return delegatedEntityPersister.getIdentifierType();
	}

	@Override
	public String getIdentifierPropertyName() {
		return delegatedEntityPersister.getIdentifierPropertyName();
	}

	@Override
	public boolean isCacheInvalidationRequired() {
		return delegatedEntityPersister.isCacheInvalidationRequired();
	}

	@Override
	public boolean isLazyPropertiesCacheable() {
		return delegatedEntityPersister.isLazyPropertiesCacheable();
	}

	@Override
	public boolean hasCache() {
		return delegatedEntityPersister.hasCache();
	}

	@Override
	public EntityRegionAccessStrategy getCacheAccessStrategy() {
		return delegatedEntityPersister.getCacheAccessStrategy();
	}

	@Override
	public CacheEntryStructure getCacheEntryStructure() {
		return delegatedEntityPersister.getCacheEntryStructure();
	}

	@Override
	public boolean hasNaturalIdCache() {
		return delegatedEntityPersister.hasNaturalIdCache();
	}

	@Override
	public NaturalIdRegionAccessStrategy getNaturalIdCacheAccessStrategy() {
		return delegatedEntityPersister.getNaturalIdCacheAccessStrategy();
	}

	@Override
	public ClassMetadata getClassMetadata() {
		return delegatedEntityPersister.getClassMetadata();
	}

	@Override
	public boolean isBatchLoadable() {
		return delegatedEntityPersister.isBatchLoadable();
	}

	@Override
	public boolean isSelectBeforeUpdateRequired() {
		return delegatedEntityPersister.isSelectBeforeUpdateRequired();
	}

	@Override
	public Object[] getDatabaseSnapshot(Serializable id,
			SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.getDatabaseSnapshot(id, session);
	}

	@Override
	public Serializable getIdByUniqueKey(Serializable key,
			String uniquePropertyName, SessionImplementor session) {
		return delegatedEntityPersister.getIdByUniqueKey(key, uniquePropertyName, session);
	}

	@Override
	public Object getCurrentVersion(Serializable id, SessionImplementor session)
			throws HibernateException {
		return delegatedEntityPersister.getCurrentVersion(id, session);
	}

	@Override
	public Object forceVersionIncrement(Serializable id, Object currentVersion,
			SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.forceVersionIncrement(id, currentVersion, session);
	}

	@Override
	public boolean isInstrumented() {
		return delegatedEntityPersister.isInstrumented();
	}

	@Override
	public boolean hasInsertGeneratedProperties() {
		return delegatedEntityPersister.hasInsertGeneratedProperties();
	}

	@Override
	public boolean hasUpdateGeneratedProperties() {
		return delegatedEntityPersister.hasUpdateGeneratedProperties();
	}

	@Override
	public boolean isVersionPropertyGenerated() {
		return delegatedEntityPersister.isVersionPropertyGenerated();
	}

	@Override
	public void afterInitialize(Object entity,
			boolean lazyPropertiesAreUnfetched, SessionImplementor session) {
		delegatedEntityPersister.afterInitialize(entity, lazyPropertiesAreUnfetched, session);
	}

	@Override
	public void afterReassociate(Object entity, SessionImplementor session) {
		delegatedEntityPersister.afterReassociate(entity, session);
	}

	@Override
	public Object createProxy(Serializable id, SessionImplementor session)
			throws HibernateException {
		return delegatedEntityPersister.createProxy(id, session);
	}

	@Override
	public Boolean isTransient(Object object, SessionImplementor session)
			throws HibernateException {
		return delegatedEntityPersister.isTransient(object, session);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getPropertyValuesToInsert(Object object, Map mergeMap,
			SessionImplementor session) throws HibernateException {
		return delegatedEntityPersister.getPropertyValuesToInsert(object, mergeMap, session);
	}

	@Override
	public void processInsertGeneratedProperties(Serializable id,
			Object entity, Object[] state, SessionImplementor session) {
		delegatedEntityPersister.processInsertGeneratedProperties(id, entity, state, session);
	}

	@Override
	public void processUpdateGeneratedProperties(Serializable id,
			Object entity, Object[] state, SessionImplementor session) {
		delegatedEntityPersister.processUpdateGeneratedProperties(id, entity, state, session);
	}

	@Override
	public Class<?> getMappedClass() {
		return delegatedEntityPersister.getMappedClass();
	}

	@Override
	public boolean implementsLifecycle() {
		return delegatedEntityPersister.implementsLifecycle();
	}

	@Override
	public Class<?> getConcreteProxyClass() {
		return delegatedEntityPersister.getConcreteProxyClass();
	}

	@Override
	public void setPropertyValues(Object object, Object[] values) {
		delegatedEntityPersister.setPropertyValues(object, values);
	}

	@Override
	public void setPropertyValue(Object object, int i, Object value) {
		delegatedEntityPersister.setPropertyValue(object, i, value);
	}

	@Override
	public Object[] getPropertyValues(Object object) {
		return delegatedEntityPersister.getPropertyValues(object);
	}

	@Override
	public Object getPropertyValue(Object object, int i) throws HibernateException {
		return delegatedEntityPersister.getPropertyValue(object, i);
	}

	@Override
	public Object getPropertyValue(Object object, String propertyName) {
		return delegatedEntityPersister.getPropertyValue(object, propertyName);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Serializable getIdentifier(Object object) throws HibernateException {
		return delegatedEntityPersister.getIdentifier(object);
	}

	@Override
	public Serializable getIdentifier(Object entity, SessionImplementor session) {
		return delegatedEntityPersister.getIdentifier(entity, session);
	}

	@Override
	public void setIdentifier(Object entity, Serializable id, SessionImplementor session) {
		delegatedEntityPersister.setIdentifier(entity, id, session);
	}

	@Override
	public Object getVersion(Object object) throws HibernateException {
		return delegatedEntityPersister.getVersion(object);
	}

	@Override
	public Object instantiate(Serializable id, SessionImplementor session) {
		return delegatedEntityPersister.instantiate(id, session);
	}

	@Override
	public boolean isInstance(Object object) {
		return delegatedEntityPersister.isInstance(object);
	}

	@Override
	public boolean hasUninitializedLazyProperties(Object object) {
		return delegatedEntityPersister.hasUninitializedLazyProperties(object);
	}

	@Override
	public void resetIdentifier(Object entity, Serializable currentId,
			Object currentVersion, SessionImplementor session) {
		delegatedEntityPersister.resetIdentifier(entity, currentId, currentVersion, session);
	}

	@Override
	public EntityPersister getSubclassEntityPersister(Object instance,
			SessionFactoryImplementor factory) {
		return delegatedEntityPersister.getSubclassEntityPersister(instance, factory);
	}

	@Override
	public EntityMode getEntityMode() {
		return delegatedEntityPersister.getEntityMode();
	}

	@Override
	public EntityTuplizer getEntityTuplizer() {
		return delegatedEntityPersister.getEntityTuplizer();
	}

	@Override
	public EntityInstrumentationMetadata getInstrumentationMetadata() {
		return delegatedEntityPersister.getInstrumentationMetadata();
	}

	@Override
	public FilterAliasGenerator getFilterAliasGenerator(String rootAlias) {
		return delegatedEntityPersister.getFilterAliasGenerator(rootAlias);
	}

}

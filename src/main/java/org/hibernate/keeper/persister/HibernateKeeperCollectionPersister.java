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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.entry.CacheEntryStructure;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.type.CollectionType;
import org.hibernate.type.Type;

/**
 * @author Serkan ÖZAL
 */
public class HibernateKeeperCollectionPersister implements CollectionPersister {

	protected CollectionPersister delegatedCollectionPersister;
	
	public HibernateKeeperCollectionPersister(CollectionPersister delegatedCollectionPersister) {
		this.delegatedCollectionPersister = delegatedCollectionPersister;
	}
	
	@Override
	public void initialize(Serializable key, SessionImplementor session)
			throws HibernateException {
		delegatedCollectionPersister.initialize(key, session);
	}

	@Override
	public boolean hasCache() {
		return delegatedCollectionPersister.hasCache();
	}

	@Override
	public CollectionRegionAccessStrategy getCacheAccessStrategy() {
		return delegatedCollectionPersister.getCacheAccessStrategy();
	}

	@Override
	public CacheEntryStructure getCacheEntryStructure() {
		return delegatedCollectionPersister.getCacheEntryStructure();
	}

	@Override
	public CollectionType getCollectionType() {
		return delegatedCollectionPersister.getCollectionType();
	}

	@Override
	public Type getKeyType() {
		return delegatedCollectionPersister.getKeyType();
	}

	@Override
	public Type getIndexType() {
		return delegatedCollectionPersister.getIndexType();
	}

	@Override
	public Type getElementType() {
		return delegatedCollectionPersister.getElementType();
	}

	@Override
	public Class<?> getElementClass() {
		return delegatedCollectionPersister.getElementClass();
	}

	@Override
	public Object readKey(ResultSet rs, String[] keyAliases,
			SessionImplementor session) throws HibernateException, SQLException {
		return delegatedCollectionPersister.readKey(rs, keyAliases, session);
	}

	@Override
	public Object readElement(ResultSet rs, Object owner, String[] columnAliases, 
			SessionImplementor session) throws HibernateException, SQLException {
		return delegatedCollectionPersister.readElement(rs, owner, columnAliases, session);
	}

	@Override
	public Object readIndex(ResultSet rs, String[] columnAliases,
			SessionImplementor session) throws HibernateException, SQLException {
		return delegatedCollectionPersister.readIndex(rs, columnAliases, session);
	}

	@Override
	public Object readIdentifier(ResultSet rs, String columnAlias,
			SessionImplementor session) throws HibernateException, SQLException {
		return delegatedCollectionPersister.readIdentifier(rs, columnAlias, session);
	}

	@Override
	public boolean isPrimitiveArray() {
		return delegatedCollectionPersister.isPrimitiveArray();
	}

	@Override
	public boolean isArray() {
		return delegatedCollectionPersister.isArray();
	}

	@Override
	public boolean isOneToMany() {
		return delegatedCollectionPersister.isOneToMany();
	}

	@Override
	public boolean isManyToMany() {
		return delegatedCollectionPersister.isManyToMany();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getManyToManyFilterFragment(String alias, Map enabledFilters) {
		return delegatedCollectionPersister.getManyToManyFilterFragment(alias, enabledFilters);
	}

	@Override
	public boolean hasIndex() {
		return delegatedCollectionPersister.hasIndex();
	}

	@Override
	public boolean isLazy() {
		return delegatedCollectionPersister.isLazy();
	}

	@Override
	public boolean isInverse() {
		return delegatedCollectionPersister.isInverse();
	}

	@Override
	public void remove(Serializable id, SessionImplementor session) throws HibernateException {
		delegatedCollectionPersister.remove(id, session);
	}

	@Override
	public void recreate(PersistentCollection collection, Serializable key,
			SessionImplementor session) throws HibernateException {
		delegatedCollectionPersister.recreate(collection, key, session);
	}

	@Override
	public void deleteRows(PersistentCollection collection, Serializable key,
			SessionImplementor session) throws HibernateException {
		delegatedCollectionPersister.deleteRows(collection, key, session);
	}

	@Override
	public void updateRows(PersistentCollection collection, Serializable key,
			SessionImplementor session) throws HibernateException {
		delegatedCollectionPersister.updateRows(collection, key, session);
	}

	@Override
	public void insertRows(PersistentCollection collection, Serializable key,
			SessionImplementor session) throws HibernateException {
		delegatedCollectionPersister.insertRows(collection, key, session);
	}

	@Override
	public String getRole() {
		return delegatedCollectionPersister.getRole();
	}

	@Override
	public EntityPersister getOwnerEntityPersister() {
		return delegatedCollectionPersister.getOwnerEntityPersister();
	}

	@Override
	public IdentifierGenerator getIdentifierGenerator() {
		return delegatedCollectionPersister.getIdentifierGenerator();
	}

	@Override
	public Type getIdentifierType() {
		return delegatedCollectionPersister.getIdentifierType();
	}

	@Override
	public boolean hasOrphanDelete() {
		return delegatedCollectionPersister.hasOrphanDelete();
	}

	@Override
	public boolean hasOrdering() {
		return delegatedCollectionPersister.hasOrdering();
	}

	@Override
	public boolean hasManyToManyOrdering() {
		return delegatedCollectionPersister.hasManyToManyOrdering();
	}

	@Override
	public Serializable[] getCollectionSpaces() {
		return delegatedCollectionPersister.getCollectionSpaces();
	}

	@Override
	public CollectionMetadata getCollectionMetadata() {
		return delegatedCollectionPersister.getCollectionMetadata();
	}

	@Override
	public boolean isCascadeDeleteEnabled() {
		return delegatedCollectionPersister.isCascadeDeleteEnabled();
	}

	@Override
	public boolean isVersioned() {
		return delegatedCollectionPersister.isVersioned();
	}

	@Override
	public boolean isMutable() {
		return delegatedCollectionPersister.isMutable();
	}

	@Override
	public String getNodeName() {
		return delegatedCollectionPersister.getNodeName();
	}

	@Override
	public String getElementNodeName() {
		return delegatedCollectionPersister.getElementNodeName();
	}

	@Override
	public String getIndexNodeName() {
		return delegatedCollectionPersister.getIndexNodeName();
	}

	@Override
	public void postInstantiate() throws MappingException {
		delegatedCollectionPersister.postInstantiate();
	}

	@Override
	public SessionFactoryImplementor getFactory() {
		return delegatedCollectionPersister.getFactory();
	}

	@Override
	public boolean isAffectedByEnabledFilters(SessionImplementor session) {
		return delegatedCollectionPersister.isAffectedByEnabledFilters(session);
	}

	@Override
	public String[] getKeyColumnAliases(String suffix) {
		return delegatedCollectionPersister.getKeyColumnAliases(suffix);
	}

	@Override
	public String[] getIndexColumnAliases(String suffix) {
		return delegatedCollectionPersister.getIndexColumnAliases(suffix);
	}

	@Override
	public String[] getElementColumnAliases(String suffix) {
		return delegatedCollectionPersister.getElementColumnAliases(suffix);
	}

	@Override
	public String getIdentifierColumnAlias(String suffix) {
		return delegatedCollectionPersister.getIdentifierColumnAlias(suffix);
	}

	@Override
	public boolean isExtraLazy() {
		return delegatedCollectionPersister.isExtraLazy();
	}

	@Override
	public int getSize(Serializable key, SessionImplementor session) {
		return delegatedCollectionPersister.getSize(key, session);
	}

	@Override
	public boolean indexExists(Serializable key, Object index,
			SessionImplementor session) {
		return delegatedCollectionPersister.indexExists(key, index, session);
	}

	@Override
	public boolean elementExists(Serializable key, Object element,
			SessionImplementor session) {
		return delegatedCollectionPersister.elementExists(key, element, session);
	}

	@Override
	public Object getElementByIndex(Serializable key, Object index,
			SessionImplementor session, Object owner) {
		return delegatedCollectionPersister.getElementByIndex(key, index, session, owner);
	}

	@Override
	public int getBatchSize() {
		return delegatedCollectionPersister.getBatchSize();
	}

}

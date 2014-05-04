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

import org.hibernate.HibernateException;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.metamodel.binding.PluralAttributeBinding;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.internal.PersisterFactoryImpl;
import org.hibernate.persister.spi.PersisterFactory;

/**
 * @author Serkan ÖZAL
 */
@SuppressWarnings("serial")
public class HibernateKeeperPersisterFactory implements PersisterFactory {

	protected PersisterFactory delegatedPersisterFactory;
	
	public HibernateKeeperPersisterFactory() {
		this.delegatedPersisterFactory = new PersisterFactoryImpl();
	}

	public HibernateKeeperPersisterFactory(PersisterFactory delegatedPersisterFactory) {
		this.delegatedPersisterFactory = 
				delegatedPersisterFactory != null ? delegatedPersisterFactory : new PersisterFactoryImpl();
	}
	
	@Override
	public EntityPersister createEntityPersister(PersistentClass model,
			EntityRegionAccessStrategy cacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdAccessStrategy,
			SessionFactoryImplementor factory, Mapping cfg) throws HibernateException {
		return 
			new HibernateKeeperEntityPersister(
					model,
					delegatedPersisterFactory.createEntityPersister(
							model, cacheAccessStrategy, naturalIdAccessStrategy, factory, cfg));
	}

	@Override
	public EntityPersister createEntityPersister(EntityBinding model,
			EntityRegionAccessStrategy cacheAccessStrategy,
			SessionFactoryImplementor factory, Mapping cfg) throws HibernateException {
		return 
			new HibernateKeeperEntityPersister(	
					model,
					delegatedPersisterFactory.createEntityPersister(
							model, cacheAccessStrategy, factory, cfg));
	}

	@Override
	public CollectionPersister createCollectionPersister(Configuration cfg,
			Collection model,
			CollectionRegionAccessStrategy cacheAccessStrategy,
			SessionFactoryImplementor factory) throws HibernateException {
		return
			new HibernateKeeperCollectionPersister(	
					delegatedPersisterFactory.createCollectionPersister(
							cfg, model, cacheAccessStrategy, factory));
	}

	@Override
	public CollectionPersister createCollectionPersister(
			MetadataImplementor metadata, PluralAttributeBinding model,
			CollectionRegionAccessStrategy cacheAccessStrategy,
			SessionFactoryImplementor factory) throws HibernateException {
		return 
			new HibernateKeeperCollectionPersister(		
					delegatedPersisterFactory.createCollectionPersister(
							metadata, model, cacheAccessStrategy, factory));
	}

}

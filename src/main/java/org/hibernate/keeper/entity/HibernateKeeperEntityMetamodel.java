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

package org.hibernate.keeper.entity;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.metamodel.binding.InheritanceType;
import org.hibernate.tuple.entity.EntityMetamodel;

/**
 * @author Serkan ÖZAL
 */
@SuppressWarnings("serial")
public class HibernateKeeperEntityMetamodel extends EntityMetamodel {

	protected EntityMetamodel delegatedEntityMetamodel;
	protected boolean[] realPropertyLaziness;
	
	public HibernateKeeperEntityMetamodel(EntityBinding entityBinding,
			SessionFactoryImplementor sessionFactory) {
		super(entityBinding, sessionFactory);
		delegatedEntityMetamodel = new EntityMetamodel(entityBinding, sessionFactory);
	}

	public HibernateKeeperEntityMetamodel(PersistentClass persistentClass,
			SessionFactoryImplementor sessionFactory) {
		super(persistentClass, sessionFactory);
		delegatedEntityMetamodel = new EntityMetamodel(persistentClass, sessionFactory);
	}
	
	public HibernateKeeperEntityMetamodel(EntityMetamodel delegatedEntityMetamodel) {
		super(
			new EntityBinding(
					// FIXME Find correct Inheritance Type
					delegatedEntityMetamodel.isInherited() ? 
							InheritanceType.TABLE_PER_CLASS : InheritanceType.NO_INHERITANCE, 
					delegatedEntityMetamodel.getEntityMode()), 
			delegatedEntityMetamodel.getSessionFactory());
		this.delegatedEntityMetamodel = delegatedEntityMetamodel;
	}
	
	@Override
	public boolean[] getPropertyLaziness() {
		boolean[] propertyLaziness =  super.getPropertyLaziness();
		if (propertyLaziness != null && realPropertyLaziness == null) {
			realPropertyLaziness = new boolean[propertyLaziness.length];
			System.arraycopy(propertyLaziness, 0, realPropertyLaziness, 0, propertyLaziness.length);
		}
		
		// TODO Set dynamic lazy property
		
		return propertyLaziness;
	}

}

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

package org.hibernate.keeper.integrator;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.keeper.persister.HibernateKeeperPersisterFactory;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.persister.spi.PersisterFactory;
import org.hibernate.service.spi.ServiceBinding;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * @author Serkan ÖZAL
 */
public class HibernateKeeperIntegrator implements Integrator {

	@Override
	public void integrate(Configuration configuration,
			SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		registerPersisterFactory(serviceRegistry);
	}

	@Override
	public void integrate(MetadataImplementor metadata,
			SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		registerPersisterFactory(serviceRegistry);
	}

	@Override
	public void disintegrate(SessionFactoryImplementor sessionFactory,
			SessionFactoryServiceRegistry serviceRegistry) {
		
	}
	
	protected void registerPersisterFactory(SessionFactoryServiceRegistry serviceRegistry) {
		ServiceBinding<PersisterFactory> persisterFactoryServiceBinding = 
				serviceRegistry.locateServiceBinding(PersisterFactory.class);
		if (persisterFactoryServiceBinding != null) {
			persisterFactoryServiceBinding.setService(
					new HibernateKeeperPersisterFactory(
							persisterFactoryServiceBinding.getService()));
		}
	}

}

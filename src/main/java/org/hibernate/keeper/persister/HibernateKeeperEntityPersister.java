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

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.FilterAliasGenerator;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metamodel.binding.EntityBinding;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.type.Type;

/**
 * @author Serkan ÖZAL
 */
public class HibernateKeeperEntityPersister extends AbstractEntityPersister {

	public HibernateKeeperEntityPersister(EntityBinding entityBinding,
			EntityRegionAccessStrategy cacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy,
			SessionFactoryImplementor factory) throws HibernateException {
		super(entityBinding, cacheAccessStrategy, naturalIdRegionAccessStrategy, factory);
		// TODO Auto-generated constructor stub
	}

	public HibernateKeeperEntityPersister(PersistentClass persistentClass,
			EntityRegionAccessStrategy cacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy,
			SessionFactoryImplementor factory) throws HibernateException {
		super(persistentClass, cacheAccessStrategy, naturalIdRegionAccessStrategy, factory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSubclassPropertyTableName(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fromTableFragment(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyTableName(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getDiscriminatorType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDiscriminatorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubclassForDiscriminatorValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable[] getPropertySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterAliasGenerator getFilterAliasGenerator(String rootAlias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDiscriminatorSQLValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getConstraintOrderedTableNameClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getContraintOrderedTableKeyColumnClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int[] getSubclassColumnTableNumberClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int[] getSubclassFormulaTableNumberClosure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubclassTableName(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getSubclassTableKeyColumns(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isClassOrSuperclassTable(int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int getSubclassTableSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getTableSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean isTableCascadeDeleteEnabled(int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getTableName(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getKeyColumns(int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isPropertyOfTable(int property, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int[] getPropertyTableNumbersInSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int[] getPropertyTableNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getSubclassPropertyTableNumber(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected String filterFragment(String alias) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

}

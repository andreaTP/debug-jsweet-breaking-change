/* 
 * JSweet transpiler - http://www.jsweet.org
 * Copyright (C) 2015 CINCHEO SAS <renaud.pawlak@cincheo.fr>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.jsweet.transpiler.model.support;

import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.ExecutableElement;

import org.jsweet.transpiler.model.ExtendedElement;
import org.jsweet.transpiler.model.ExtendedElementFactory;
import org.jsweet.transpiler.model.NewClassElement;

import com.sun.tools.javac.tree.JCTree.JCNewClass;

/**
 * See {@link NewClassElement}.
 * 
 * @author Renaud Pawlak
 */
public class NewClassElementSupport extends ExtendedElementSupport<JCNewClass> implements NewClassElement {

	public NewClassElementSupport(JCNewClass tree) {
		super(tree);
	}

	public List<ExtendedElement> getArguments() {
		return tree.args.stream().map(a -> ExtendedElementFactory.INSTANCE.create(a)).collect(Collectors.toList());
	}

	@Override
	public int getArgumentCount() {
		return tree.args.size();
	}

	@Override
	public List<ExtendedElement> getArgumentTail() {
		return tree.args.tail.stream().map(a -> ExtendedElementFactory.INSTANCE.create(a)).collect(Collectors.toList());
	}

	@Override
	public ExtendedElement getArgument(int i) {
		return ExtendedElementFactory.INSTANCE.create(tree.args.get(i));
	}

	@Override
	public ExecutableElement getConstructor() {
		return (ExecutableElement) tree.constructor;
	}

	@Override
	public ExtendedElement getConstructorAccess() {
		return ExtendedElementFactory.INSTANCE.create(tree.clazz);
	}

}

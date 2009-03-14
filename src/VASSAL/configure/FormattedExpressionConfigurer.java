/*
 * $Id: FormattedExpressionConfigurer.java,v 1.3 2006/09/29 06:48:21 swampwallaby Exp $
 *
 * Copyright (c) 2008 by Brent Easton
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License (LGPL) as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, copies are available 
 * at http://www.opensource.org.
 */
package VASSAL.configure;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import VASSAL.tools.icon.IconFactory;
import VASSAL.tools.icon.IconFamily;

/**
 * A standard Formatted String configurer that has an additional
 * Calculator icon that:
 *   a) Indicates to the user that $name$ variables can be used in this field
 *   b) Clicking on it opens up an Expression Builder that allows entry of
 *      in-line Calculated Properties (Not implemented yet)
 */
public class FormattedExpressionConfigurer extends FormattedStringConfigurer {
  private ExpressionButton button;
  
  public FormattedExpressionConfigurer(String key, String name) {
    super(key, name);
  }

  public FormattedExpressionConfigurer(String key, String name, String s) {
    super(key, name);
    setValue(s);
  }

  public FormattedExpressionConfigurer(String key, String name, String[] options) {
    super(key, name, options);
  }

  public java.awt.Component getControls() {
    final JPanel p = (JPanel) super.getControls();
    if (button == null) {
      button = new ExpressionButton(this, nameField.getPreferredSize().height);
      p.add(button);
    }
    button.setSize(nameField.getPreferredSize().height);
    return p;
  }
  
  /**
   * A small 'Calculator' button added after the text to indicate this
   * Configurer accepts Expressions. Clicking on the button will open 
   * an ExpressionConfigurer.
   *
   */
  public static class ExpressionButton extends JButton implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Configurer config;

    public ExpressionButton(Configurer config, int size) {
      this.config = config;
      setIcon(IconFactory.getIcon("calculator", IconFamily.XSMALL));
      setSize(size);
      setToolTipText("Expression Builder (not implemented yet)");
      addActionListener(this);
    }

    public void setSize(int size) {
      setPreferredSize(new Dimension(size, size));
      setMaximumSize(new Dimension(size, size));
    }
    
    public void actionPerformed(ActionEvent e) {
      //new ExpressionBuilder(config, (JDialog) getTopLevelAncestor()).setVisible(true);   
    }
  }
}
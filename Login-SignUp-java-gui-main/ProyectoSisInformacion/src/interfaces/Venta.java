
package interfaces;

import datosGenerales.CVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.text.DecimalFormat;



public class Venta extends javax.swing.JFrame {

 
    public Venta() {
       initComponents();
       setResizable(false);
       this.setTitle("SMARTVAULT - REALIZAR VENTA");
       CVentas objetoVentas = new CVentas();
       objetoVentas.mostrarProductos(tablaVentas);
       campoIdVenta.setEnabled(false);
       campoTotalVenta.setEnabled(false);
       // Agregar un ActionListener al campo precioUnitario
        campoPrecioUnitario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });

        // Agregar un ActionListener al campo cantidadVendida
        campoCantidadVendida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
        ImageIcon icono = new ImageIcon(getClass().getResource("/Icon/money.png"));
    // Verificar si la imagen se cargó correctamente
    if (icono != null) {
        // Establecer el icono
        this.setIconImage(icono.getImage());
    } else {
        System.out.println("No se pudo cargar la imagen del icono.");
    }
    }
    
    
    private void calcularTotal() {
        // Obtener los valores de los campos
        String precioUnitarioStr = campoPrecioUnitario.getText();
        String cantidadVendidaStr = campoCantidadVendida.getText();
        
        // Verificar si ambos campos tienen valores
        if (!precioUnitarioStr.isEmpty() && !cantidadVendidaStr.isEmpty()) {
            try {
                DecimalFormat df = new DecimalFormat("#.00");
                // Convertir las cadenas a números
                double precioUnitario = Double.parseDouble(precioUnitarioStr);
                
                int cantidadVendida = Integer.parseInt(cantidadVendidaStr);

                // Calcular el total
                double total = precioUnitario * cantidadVendida;
                total = Math.round(total * 100.0) / 100.0;
                // Mostrar el total en el campo correspondiente
                campoTotalVenta.setText(String.valueOf(total));
            } catch (NumberFormatException ex) {
                // Manejar la excepción si no se pueden convertir a números
                ex.printStackTrace();
            }
        } else {
            // Si alguno de los campos está vacío, limpiar el campo total
            campoTotalVenta.setText("");
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnResumen = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        campoIdVendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoCantidadVendida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoPrecioUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoTotalVenta = new javax.swing.JTextField();
        campoIDProducto = new javax.swing.JLabel();
        campoIdVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoFechaVenta = new javax.swing.JTextField();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");

        jPanel1.setBackground(new java.awt.Color(46, 139, 87));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(75, 75, 75));
        jPanel3.setAutoscrolls(true);
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SMARTVAULT");

        btnResumen.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnResumen.setText("Resumen");
        btnResumen.setBorder(null);
        btnResumen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnUsuarios.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnInventario.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(null);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnVenta.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.setBorder(null);
        btnVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(-10, 0, 250, 520);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

        tablaVentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaVentas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(240, 80, 770, 430);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENTAS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(560, 30, 120, 20);

        jPanel2.setBackground(new java.awt.Color(75, 75, 75));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setEnabled(false);

        btnAgregarProducto.setBackground(new java.awt.Color(0, 51, 102));
        btnAgregarProducto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(46, 139, 87));
        btnEditarProducto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setText("Editar");
        btnEditarProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(128, 0, 0));
        btnEliminarProducto.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio Unitario");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total");

        campoTotalVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        campoTotalVenta.setEnabled(false);

        campoIDProducto.setForeground(new java.awt.Color(255, 255, 255));
        campoIDProducto.setText("ID");

        campoIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdVentaActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha de venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(campoIdVendedor)
                            .addComponent(jLabel4)
                            .addComponent(campoCantidadVendida, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(campoPrecioUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(campoTotalVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(campoIDProducto)
                            .addComponent(campoIdVenta)
                            .addComponent(campoFechaVenta))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(campoIDProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCantidadVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        // TODO add your handling code here:
        resumen int2Frame = new resumen();
        int2Frame.setVisible(true);
        int2Frame.pack();
        int2Frame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btnResumenActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        productos productosFrame = new productos();
        productosFrame.setVisible(true);
        productosFrame.pack();
        productosFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        Usuarios UsuariosFrame = new Usuarios();
        UsuariosFrame.setVisible(true);
        UsuariosFrame.pack();
        UsuariosFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        Inventario inventarioFrame = new Inventario();
        inventarioFrame.setVisible(true);
        inventarioFrame.pack();
        inventarioFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:
        Venta VentaFrame = new Venta();
        VentaFrame.setVisible(true);
        VentaFrame.pack();
        VentaFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
           CVentas objetoVentas = new CVentas();
           objetoVentas.eliminarProductos(campoIdVenta);
           objetoVentas.mostrarProductos(tablaVentas);
           
           //pack();
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        CVentas objetoVentas = new CVentas();
        objetoVentas.insertarVenta(campoIdVendedor, campoCantidadVendida, campoPrecioUnitario, campoTotalVenta, campoFechaVenta);
        objetoVentas.mostrarProductos(tablaVentas);
       
        
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        // TODO add your handling code here:
        CVentas objetoVentas = new CVentas();
        objetoVentas.modificarProductos(campoIdVenta, campoIdVendedor, campoCantidadVendida, campoPrecioUnitario, campoTotalVenta, campoFechaVenta);
        objetoVentas.mostrarProductos(tablaVentas);   
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        // TODO add your handling code here:
        CVentas objetoVentas = new CVentas();
        objetoVentas.seleccionarVentas(tablaVentas, campoIdVenta, campoIdVendedor, campoCantidadVendida, campoPrecioUnitario, campoTotalVenta, campoFechaVenta);
        
        
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void campoIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdVentaActionPerformed

 
       
     

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnResumen;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVenta;
    private javax.swing.JTextField campoCantidadVendida;
    private javax.swing.JTextField campoFechaVenta;
    private javax.swing.JLabel campoIDProducto;
    private javax.swing.JTextField campoIdVendedor;
    private javax.swing.JTextField campoIdVenta;
    private javax.swing.JTextField campoPrecioUnitario;
    private javax.swing.JTextField campoTotalVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}

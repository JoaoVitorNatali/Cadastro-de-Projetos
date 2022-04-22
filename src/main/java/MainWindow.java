
import Empresas.FormularioEmpresa;
import Professores.FormularioProfessor;
import Projetos.FormularioProjeto;
import Alunos.FormularioAluno;
import Alunos.TableModelAluno;
import static Constantes.TipoFormulario.EDITAR;
import static Constantes.TipoFormulario.INSERIR;
import Empresas.TableModelEmpresa;
import Professores.TableModelProfessor;
import Projetos.TableModelProjeto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author João Vitor
 */
public class MainWindow extends javax.swing.JFrame {
    
//    Componentes de formulario para criar
    private FormularioAluno formularioAluno;
    private FormularioEmpresa formularioEmpresa;
    private FormularioProfessor formularioProfessor;
    private FormularioProjeto formularioProjeto;
    
    
    private TableModelAluno tabelaAlunos;
    private TableModelProjeto tabelaProjetos;
    private TableModelProfessor tabelaProfessores;
    private TableModelEmpresa tabelaEmpresas;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        formularioAluno = new FormularioAluno(this, true);
        formularioEmpresa = new FormularioEmpresa(this, true);
        formularioProfessor = new FormularioProfessor(this, true);
        formularioProjeto = new FormularioProjeto(this, true);

        initComponents();
        iniciarTabelas();
    }
    
    private void iniciarTabelas(){
        tabelaAlunos = new TableModelAluno();
        tabelaProjetos = new TableModelProjeto();
        tabelaProfessores = new TableModelProfessor();
        tabelaEmpresas = new TableModelEmpresa();
        
        jtbListaAlunos.setModel(tabelaAlunos);
        jtbListaProjetos.setModel(tabelaProjetos);
        jtbListaProfessores.setModel(tabelaProfessores);
        jtbListaEmpresas.setModel(tabelaEmpresas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnNovoProjeto = new javax.swing.JButton();
        listagemProjetos = new javax.swing.JScrollPane();
        jtbListaProjetos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnEditarProjeto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnFiltrarProjetos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNovoAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbListaAlunos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnEditarAluno = new javax.swing.JButton();
        btnFiltrarAlunos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnNovoProfessor = new javax.swing.JButton();
        containerprofessores = new javax.swing.JScrollPane();
        jtbListaProfessores = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        btnEditarProfessor = new javax.swing.JButton();
        btnFiltrarProfessores = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnNovaEmpresa = new javax.swing.JButton();
        containerempresas = new javax.swing.JScrollPane();
        jtbListaEmpresas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        btnEditarEmpresa = new javax.swing.JButton();
        btnFiltrarEmpresas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNovoProjeto.setText("Novo projeto");
        btnNovoProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProjetoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovoProjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        jtbListaProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listagemProjetos.setViewportView(jtbListaProjetos);

        jPanel1.add(listagemProjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 800, 280));

        jButton1.setText("Excluir");

        btnEditarProjeto.setText("Editar");
        btnEditarProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProjetoActionPerformed(evt);
            }
        });

        jButton3.setText("Abrir Projeto");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                .addComponent(btnEditarProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnEditarProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 800, -1));

        btnFiltrarProjetos.setText("Filtrar resultados");
        btnFiltrarProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarProjetosActionPerformed(evt);
            }
        });
        jPanel1.add(btnFiltrarProjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 40));

        jTabbedPane1.addTab("Projetos", jPanel1);

        btnNovoAluno.setText("Novo aluno");
        btnNovoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAlunoActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jtbListaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbListaAlunos);

        jButton4.setText("Excluir");

        btnEditarAluno.setText("Editar");
        btnEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(btnEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnFiltrarAlunos.setText("Filtrar resultados");
        btnFiltrarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarAlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnFiltrarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrarAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alunos", jPanel2);

        btnNovoProfessor.setText("Novo professor");
        btnNovoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProfessorActionPerformed(evt);
            }
        });

        containerprofessores.setBorder(null);

        jtbListaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        containerprofessores.setViewportView(jtbListaProfessores);

        jButton7.setText("Excluir");

        btnEditarProfessor.setText("Editar");
        btnEditarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProfessorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(btnEditarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnFiltrarProfessores.setText("Filtrar resultados");
        btnFiltrarProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarProfessoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrarProfessores)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(containerprofessores)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovoProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnFiltrarProfessores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(containerprofessores, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Professores", jPanel3);

        btnNovaEmpresa.setText("Nova Empresa");
        btnNovaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaEmpresaActionPerformed(evt);
            }
        });

        containerempresas.setBorder(null);

        jtbListaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        containerempresas.setViewportView(jtbListaEmpresas);

        jButton9.setText("Excluir");

        btnEditarEmpresa.setText("Editar");
        btnEditarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(btnEditarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnFiltrarEmpresas.setText("Filtrar resultados");
        btnFiltrarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarEmpresasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerempresas)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnNovaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFiltrarEmpresas))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNovaEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnFiltrarEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(containerempresas, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empresas", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProjetoActionPerformed
        formularioProjeto.abrirModalCriacao();
    }//GEN-LAST:event_btnNovoProjetoActionPerformed

    private void btnNovoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAlunoActionPerformed
        formularioAluno.abrirModalCriacao();
    }//GEN-LAST:event_btnNovoAlunoActionPerformed

    private void btnNovoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProfessorActionPerformed
        formularioProfessor.abrirModalCriacao();
    }//GEN-LAST:event_btnNovoProfessorActionPerformed

    private void btnNovaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaEmpresaActionPerformed
        formularioEmpresa.abrirModalCriacao();
    }//GEN-LAST:event_btnNovaEmpresaActionPerformed

    private void btnFiltrarProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarProjetosActionPerformed
        formularioProjeto.abrirModalFiltragem();
    }//GEN-LAST:event_btnFiltrarProjetosActionPerformed

    private void btnFiltrarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarAlunosActionPerformed
        formularioAluno.abrirModalFiltragem();
    }//GEN-LAST:event_btnFiltrarAlunosActionPerformed

    private void btnFiltrarProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarProfessoresActionPerformed
        formularioProfessor.abrirModalFiltragem();
    }//GEN-LAST:event_btnFiltrarProfessoresActionPerformed

    private void btnFiltrarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarEmpresasActionPerformed
        formularioEmpresa.abrirModalFiltragem();
    }//GEN-LAST:event_btnFiltrarEmpresasActionPerformed

    private void btnEditarProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProjetoActionPerformed
        formularioProjeto.abrirModalEdicao(1);
    }//GEN-LAST:event_btnEditarProjetoActionPerformed

    private void btnEditarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlunoActionPerformed
        formularioAluno.abrirModalEdicao(1);
    }//GEN-LAST:event_btnEditarAlunoActionPerformed

    private void btnEditarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProfessorActionPerformed
        formularioProfessor.abrirModalEdicao(1);
    }//GEN-LAST:event_btnEditarProfessorActionPerformed

    private void btnEditarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpresaActionPerformed
        formularioEmpresa.abrirModalEdicao(1);
    }//GEN-LAST:event_btnEditarEmpresaActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAluno;
    private javax.swing.JButton btnEditarEmpresa;
    private javax.swing.JButton btnEditarProfessor;
    private javax.swing.JButton btnEditarProjeto;
    private javax.swing.JButton btnFiltrarAlunos;
    private javax.swing.JButton btnFiltrarEmpresas;
    private javax.swing.JButton btnFiltrarProfessores;
    private javax.swing.JButton btnFiltrarProjetos;
    private javax.swing.JButton btnNovaEmpresa;
    private javax.swing.JButton btnNovoAluno;
    private javax.swing.JButton btnNovoProfessor;
    private javax.swing.JButton btnNovoProjeto;
    private javax.swing.JScrollPane containerempresas;
    private javax.swing.JScrollPane containerprofessores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtbListaAlunos;
    private javax.swing.JTable jtbListaEmpresas;
    private javax.swing.JTable jtbListaProfessores;
    private javax.swing.JTable jtbListaProjetos;
    private javax.swing.JScrollPane listagemProjetos;
    // End of variables declaration//GEN-END:variables
}

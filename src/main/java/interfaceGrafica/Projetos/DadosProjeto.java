/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaceGrafica.Projetos;

import gerTarefas.gerInterface.Projeto.GerenciadorProjeto;
import modelo.Projeto;

/**
 *
 * @author João Vitor
 */
public class DadosProjeto extends javax.swing.JDialog {
    
    private final GerenciadorProjeto gerenciador;
    
   
    /**
     * Creates new form DadosProjeto
     * @param parent
     * @param modal
     * @param gerenciador
     */
    public DadosProjeto(java.awt.Frame parent, boolean modal, GerenciadorProjeto gerenciador) {
        super(parent, modal);
        
        initComponents();
        this.gerenciador = gerenciador;
        iniciarTabelas();
    }
    
    private void iniciarTabelas(){
        gerenciador.getAlunosProjeto().setTabelaProjeto(tabelaAlunos);
        gerenciador.getProfessoresProjeto().setTabelaProjeto(tabelaProfessores);
        gerenciador.getEmpresasProjeto().setTabelaProjeto(tabelaEmpresas);
    }
    
    public void abrirProjeto(Projeto projeto){
        popularCamposProjeto(projeto);
        this.setVisible(true);
    }
    
    public void popularCamposProjeto(Projeto projeto){
        descricaoProjeto.setText(projeto.getDescricao());
        tituloProjeto.setText(projeto.getTitulo());
        listarTabelas();
        
//        gerenciador.getProjeto().listarAlunos();
//        gerenciador.getProjeto().listarProfessores();
//        gerenciador.getProjeto().listarEmpresas();
    }
    
    private void listarTabelas(){
        gerenciador.listarTabelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloProjeto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        adicionarProfessor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        descricaoProjeto = new javax.swing.JTextArea();
        adicionarEmpresa = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaEmpresas = new javax.swing.JTable();
        adicionarAluno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        removerAluno = new javax.swing.JButton();
        removerProfessor = new javax.swing.JButton();
        removerEmpresa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tituloProjeto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tituloProjeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloProjeto.setText("Titulo do projeto");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jScrollPane1.setBorder(null);

        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaAlunos);

        jPanel1.add(jScrollPane1);

        jPanel2.setPreferredSize(new java.awt.Dimension(50, 267));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jScrollPane2.setBorder(null);

        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaProfessores);

        jPanel1.add(jScrollPane2);

        jLabel3.setText("Professores:");

        adicionarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/Imagens/add.png"))); // NOI18N
        adicionarProfessor.setText("Adicionar professor");
        adicionarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarProfessorActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setEnabled(false);

        descricaoProjeto.setEditable(false);
        descricaoProjeto.setColumns(20);
        descricaoProjeto.setRows(5);
        descricaoProjeto.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        jScrollPane3.setViewportView(descricaoProjeto);

        adicionarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/imagens/add.png"))); // NOI18N
        adicionarEmpresa.setText("Adicionar Empresa");
        adicionarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarEmpresaActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(null);

        tabelaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabelaEmpresas);

        adicionarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/Imagens/add.png"))); // NOI18N
        adicionarAluno.setText("Adicionar aluno");
        adicionarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAlunoActionPerformed(evt);
            }
        });

        jLabel2.setText("Alunos do projeto:");

        removerAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/imagens/remove.png"))); // NOI18N
        removerAluno.setText("Remover");
        removerAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerAlunoActionPerformed(evt);
            }
        });

        removerProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/imagens/remove.png"))); // NOI18N
        removerProfessor.setText("Remover");
        removerProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerProfessorActionPerformed(evt);
            }
        });

        removerEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/imagens/remove.png"))); // NOI18N
        removerEmpresa.setText("Remover");
        removerEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(adicionarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(removerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(152, 152, 152)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(adicionarProfessor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(removerProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(419, 419, 419)
                                .addComponent(adicionarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(removerEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloProjeto)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adicionarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removerEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAlunoActionPerformed
        gerenciador.getAlunosProjeto().abrirListagem();
    }//GEN-LAST:event_adicionarAlunoActionPerformed

    private void adicionarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarProfessorActionPerformed
        gerenciador.getProfessoresProjeto().abrirListagem();
    }//GEN-LAST:event_adicionarProfessorActionPerformed

    private void adicionarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarEmpresaActionPerformed
        gerenciador.getEmpresasProjeto().abrirListagem();
    }//GEN-LAST:event_adicionarEmpresaActionPerformed

    private void removerAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removerAlunoActionPerformed

    private void removerProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removerProfessorActionPerformed

    private void removerEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removerEmpresaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarAluno;
    private javax.swing.JButton adicionarEmpresa;
    private javax.swing.JButton adicionarProfessor;
    private javax.swing.JTextArea descricaoProjeto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton removerAluno;
    private javax.swing.JButton removerEmpresa;
    private javax.swing.JButton removerProfessor;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTable tabelaEmpresas;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JLabel tituloProjeto;
    // End of variables declaration//GEN-END:variables
}

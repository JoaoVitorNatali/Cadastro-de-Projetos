package interfaceGrafica.Alunos;


import gerTarefas.gerInterface.Constantes.Coordenadoria;
import gerTarefas.gerInterface.Constantes.TipoFormulario;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.EDITAR;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.FILTRAR;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.INSERIR;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.custom.CustomFormularioInterface;
import gerTarefas.gerInterface.custom.ValidaCampoForm;
import modelo.Aluno;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author João Vitor
 */
public class FormularioAluno extends javax.swing.JDialog implements CustomFormularioInterface {
    private TipoFormulario tipo;
    private GerenciadorInterface gerenciador;

    /**
     * Creates new form CadastroAluno
     * @param parent
     * @param modal
     * @param gerenciador
     */
    public FormularioAluno(java.awt.Frame parent, boolean modal, GerenciadorInterface gerenciador) {
        super(parent, modal);
        this.gerenciador = gerenciador;
        this.tipo = INSERIR;
        initComponents();
    }

    @Override
    public void abrirModalEdicao(int codigoAluno){
        this.tipo = EDITAR;
        alterarTituloModal();
        this.setVisible(true);
    }

    @Override
    public void abrirModalCriacao(){
        this.tipo = INSERIR;
        alterarTituloModal();
        this.setVisible(true);
    }
    
    @Override
    public void abrirModalFiltragem() {
        this.tipo = FILTRAR;
        alterarTituloModal();
        this.setVisible(true);
    }

    @Override
    public void alterarTituloModal(){
        String titulo = "";
        if(null != this.tipo) switch (this.tipo) {
            case INSERIR:
                titulo = "Novo Aluno";
                break;
            case EDITAR:
                titulo = "Editar Aluno";
                break;
            case FILTRAR:
                titulo = "Filtrar Aluno";
                break;
            default:
                break;
        }
        
        tituloModal.setText(titulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloModal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nomeAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        matriculaAluno = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cursoAluno = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        emailAluno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefoneAluno = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tituloModal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloModal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloModal.setText("Novo Aluno");
        tituloModal.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setText("Nome do aluno:");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Matrícula:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 244, 24));

        try {
            matriculaAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(matriculaAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Curso:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 20));
        jPanel4.add(cursoAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        jPanel2.add(jPanel4);

        jLabel5.setText("Telefone:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Concluir");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel6.setText("E-mail:");

        try {
            telefoneAluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(telefoneAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailAluno))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(nomeAluno))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(telefoneAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(tituloModal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloModal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        closeModal();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        gerenciador.getAluno().concluir();        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        for(Coordenadoria item : Coordenadoria.values()){
            cursoAluno.addItem(item);
        }
    }//GEN-LAST:event_formComponentShown
    
    @Override
    public void closeModal() {
        this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Object> cursoAluno;
    private javax.swing.JTextField emailAluno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JFormattedTextField matriculaAluno;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JFormattedTextField telefoneAluno;
    private javax.swing.JLabel tituloModal;
    // End of variables declaration//GEN-END:variables

    @Override
    public Aluno toObject() {
        String nome = ValidaCampoForm.getTexto(nomeAluno, this, "Insira um nome válido");
        String matricula = ValidaCampoForm.getTexto(matriculaAluno, this, "Insira uma matricula válida");
        Coordenadoria curso = (Coordenadoria) ValidaCampoForm.getValue(cursoAluno, this);
        String telefone = ValidaCampoForm.getTelefone(telefoneAluno, this, "Insira um telefone válido");
        String email = ValidaCampoForm.getEmail(emailAluno, this, "Insira um e-mail válido");
        
        if(nome.equals("") || matricula.equals("") || telefone.equals("") || email.equals("")){
            return null;
        }
        
        Aluno aluno = new Aluno(nome, matricula, curso, telefone, email);
        return aluno;
    }

    @Override
    public TipoFormulario getTipo() {
        return this.tipo;
    }
}

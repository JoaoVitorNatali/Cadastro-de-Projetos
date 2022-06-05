package interfaceGrafica.Projetos;

import gerTarefas.gerInterface.Constantes.TipoFormulario;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.EDITAR;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.FILTRAR;
import static gerTarefas.gerInterface.Constantes.TipoFormulario.INSERIR;
import gerTarefas.gerInterface.GerenciadorInterface;
import gerTarefas.gerInterface.custom.CustomFormularioInterface;
import gerTarefas.gerInterface.custom.ValidaCampoForm;
import modelo.Projeto;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author João Vitor
 */
public class FormularioProjeto extends javax.swing.JDialog implements CustomFormularioInterface {
    private TipoFormulario tipo;
    private GerenciadorInterface gerenciador;

    /**
     * Creates new form CadastroProjeto
     * @param parent
     * @param modal
     * @param gerenciador
     */
    public FormularioProjeto(java.awt.Frame parent, boolean modal,GerenciadorInterface gerenciador) {
        super(parent, modal);
        this.tipo = INSERIR;
        this.gerenciador = gerenciador;
        initComponents();
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
        tituloProjeto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dataInicio = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dataFim = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoProjeto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tituloModal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloModal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloModal.setText("Novo Projeto");
        tituloModal.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setText("Título do projeto:");

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Início:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 244, 24));

        try {
            dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicio.setActionCommand("<Not Set>");
        jPanel3.add(dataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 240, 30));

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Fim (opcional):");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 20));

        try {
            dataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(dataFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        jPanel2.add(jPanel4);

        descricaoProjeto.setColumns(20);
        descricaoProjeto.setRows(5);
        jScrollPane1.setViewportView(descricaoProjeto);

        jLabel5.setText("Descrição:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloProjeto)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        this.gerenciador.getProjeto().concluir();
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JFormattedTextField dataFim;
    private javax.swing.JFormattedTextField dataInicio;
    private javax.swing.JTextArea descricaoProjeto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tituloModal;
    private javax.swing.JTextField tituloProjeto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void abrirModalEdicao(int codigo) {
        this.tipo = EDITAR;
        alterarTituloModal();
        this.setVisible(true);
    }

    @Override
    public void abrirModalCriacao() {
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
    public void alterarTituloModal() {
        String titulo = "";
        if(null != this.tipo) switch (this.tipo) {
            case INSERIR:
                titulo = "Novo Projeto";
                break;
            case EDITAR:
                titulo = "Editar Projeto";
                break;
            case FILTRAR:
                titulo = "Filtrar Projeto";
                break;
            default:
                break;
        }
        
        tituloModal.setText(titulo);
    }

    @Override
    public void closeModal() {
        this.dispose();
    }

    @Override
    public Projeto toObject() {
        String titulo = ValidaCampoForm.getTexto(tituloProjeto, this, "Insira um titulo válido");
        String inicio = ValidaCampoForm.getTexto(dataInicio, this, "Insira uma data de início válida");
        String fim = dataFim.getText();
        String descricao = ValidaCampoForm.getTexto(descricaoProjeto, this, "Insira um titulo válido");
        
        if(fim.equals("  /  /    ")) fim = "";
        
        if(titulo.equals("") || inicio.equals("") || descricao.equals("")) return null;
        
        Projeto projeto = new Projeto(titulo, inicio, fim, descricao);
        return projeto;
    }

    @Override
    public TipoFormulario getTipo() {
        return this.tipo;
    }
}

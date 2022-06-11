/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas.gerInterface;
import gerTarefas.gerDominio.GerenciadorDominio;
import interfaceGrafica.MainWindow;

/**
 *
 * @author João Vitor
 */
public class GerenciadorInterface {
    private MainWindow janelaPrincipal = null;
    private GerenciadorDominio gerDom = null;
    
    private GerenciadorAluno aluno = null;
    private GerenciadorEmpresa empresa = null;
    private GerenciadorProfessor professor = null;
    private GerenciadorProjeto projeto = null;

    public GerenciadorInterface() {
        gerDom = new GerenciadorDominio();
    }

    public void abrirJanelaPrincipal(){
        if(this.janelaPrincipal == null){
            this.janelaPrincipal = new MainWindow(this);
        }
        this.janelaPrincipal.setVisible(true);
        this.janelaPrincipal.iniciarTabelas();
    }
    
    public GerenciadorAluno getAluno(){
        if(this.aluno == null){
            this.aluno = new GerenciadorAluno(this.janelaPrincipal, this);
        }
        return this.aluno;
    }
    
    public GerenciadorEmpresa getEmpresa() {
        if(this.empresa == null){
            this.empresa = new GerenciadorEmpresa(this.janelaPrincipal, this);
        }
        return this.empresa;
    }
    
    public GerenciadorProfessor getProfessor(){
        if(this.professor == null){
            this.professor = new GerenciadorProfessor(this.janelaPrincipal, this);
        }
        return this.professor;
    }
    
    public GerenciadorProjeto getProjeto(){
        if(this.projeto == null){
            this.projeto = new GerenciadorProjeto(this.janelaPrincipal, this);
        }
        return this.projeto;
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        GerenciadorInterface gereIG = new GerenciadorInterface();
        gereIG.abrirJanelaPrincipal();
    }
}

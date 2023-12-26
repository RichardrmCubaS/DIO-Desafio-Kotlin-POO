enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val cpf: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        println("Usuário(s) matriculado(s) na formação $nome.")
    }
    
    fun exibirInformacoes() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos Educacionais:")
        
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} (Duração: ${conteudo.duracao} minutos)")
        }
        println("Inscritos:")
        for (usuario in inscritos) {
            println("Nome:${usuario.nome},Cpf:${usuario.cpf}")
        }
    } 
}

fun main() {
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação")
    val conteudo2 = ConteudoEducacional("Banco de Dados", 90)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web", 120)

    val formacaoTI = Formacao("Formação em TI", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    val usuario1 = Usuario("João Peres","700.900.800-01")
    val usuario2 = Usuario("Maria Da Silva","600.300.200-02")

    formacaoTI.matricular(usuario1, usuario2)

    formacaoTI.exibirInformacoes()
}

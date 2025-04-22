package personagem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface personagemRepository extends JpaRepository <Personagem, Long> {
}

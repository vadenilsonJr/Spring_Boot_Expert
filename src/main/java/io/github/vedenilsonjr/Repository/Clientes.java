package io.github.vedenilsonjr.Repository;

import io.github.vedenilsonjr.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class Clientes {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Cliente> buscarPorNome(String nome){
        String jpql = "select c from Cliente c where c.nome like :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }
    @Transactional
    public void deletar(Cliente cliente){
        entityManager.remove(cliente);
    }
    @Transactional
    public void deletar(int id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deletar(cliente);

    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }
    @Transactional(readOnly = true)
    public List<Cliente> obterTodos(){
        return  entityManager.createQuery("from cliente", Cliente.class).getResultList();
    }


}

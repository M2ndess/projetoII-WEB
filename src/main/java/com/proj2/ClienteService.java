package com.proj2;
import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{
    private final ClienteRepository ClienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.ClienteRepository = clienteRepository;
    }

    public Boolean CheckUsernameANDEmail(String username, String email){
        ClienteEntity existingUser = ClienteRepository.findByUsername(username);
        ClienteEntity existingUserEmail = ClienteRepository.findByEmail(email);
        return existingUser != null || existingUserEmail != null;
    }
}

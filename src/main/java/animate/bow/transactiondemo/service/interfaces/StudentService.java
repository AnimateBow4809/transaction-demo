package animate.bow.transactiondemo.service.interfaces;

import org.springframework.data.jpa.repository.Query;

public interface StudentService {

    public void updateNameById(Long id,String name);

    public void updateLastNameById(Long id,String lastName);

    public void updatePhoneNumberById(Long id,String phoneNumber);
}

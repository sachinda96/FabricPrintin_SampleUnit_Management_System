/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.fps.buisness.custom.impl;

import java.sql.Connection;
import lk.ijse.fps.buisness.custom.ItemBO;
import lk.ijse.fps.dto.ItemDTO;
import lk.ijse.fps.entity.Item;
import lk.ijse.fps.repository.RepositoryFactory;
import lk.ijse.fps.repository.custom.ItemRepository;
import lk.ijse.fps.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Sachinda Nipun
 * 
 */
public class ItemBOImpl implements ItemBO {

    private ItemRepository itemRepository;

    public ItemBOImpl() {
        itemRepository = (ItemRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemDTO item) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            itemRepository.setSession(session);
            
            session.beginTransaction();
            Item i = new Item(item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQytOnHand());
            boolean result = itemRepository.save(i);
            
            session.getTransaction().commit();
            return result;
        }
    }

}

package org.wecancodeit.Repositories;

import org.springframework.data.repository.CrudRepository;

import org.wecancodeit.Models.RoboticPetModel;

public interface RoboticPetRepository extends CrudRepository <RoboticPetModel, Long>{

   /**
    * 
    * @param petManufacturer
    * @return
    */
      Iterable<RoboticPetModel> findByManufacturer(String petManufacturer);

}
package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gateMap=new TreeMap<>();
    private Long previousId;

    public Gate save(Gate gate){
        if(gate.getId()==null){
            //create new gate with new id;
            gate.setId(++previousId);
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }

public Optional<Gate> findGateById(Long id){
        if(gateMap.containsKey(id)){
            return Optional.of(gateMap.get(id));
        }
        return Optional.empty();
}

public Gate delete(Long id){
   return gateMap.remove(id);
}

}

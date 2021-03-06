package de.fau.cs.mad.fablab.rest.server.resources;

import de.fau.cs.mad.fablab.rest.api.PushApi;
import de.fau.cs.mad.fablab.rest.core.DoorState;
import de.fau.cs.mad.fablab.rest.core.PushToken;
import de.fau.cs.mad.fablab.rest.core.TriggerPushType;
import de.fau.cs.mad.fablab.rest.server.core.pushservice.PushFacade;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.core.Response;


public class PushResource implements PushApi{

    @UnitOfWork
    @Override
    public Boolean subscribeDoorOpensNextTime(PushToken pushToken) {
        pushToken.setTriggerPushType(TriggerPushType.DOOR_OPENS_NEXT_TIME);
        return PushFacade.getInstance().subscribeDoorOpensNextTime(pushToken);
    }

    @UnitOfWork
    @Override
    public Boolean unsubscribeDoorOpensNextTime(PushToken pushToken) {
        pushToken.setTriggerPushType(TriggerPushType.DOOR_OPENS_NEXT_TIME);
        return  PushFacade.getInstance().unsubscribeDoorOpensNextTime(pushToken);
    }

    @UnitOfWork
    @Override
    public Boolean doorOpensNextTimeIsSetForToken(String pushToken) {
        return PushFacade.getInstance().doorOpensNextTimeIsSetForToken(new PushToken(pushToken));
    }

    @UnitOfWork
    @Override
    public Response test() {
        DoorState doorState = new DoorState();
        doorState.state = DoorState.State.invalid;
        doorState.time = System.currentTimeMillis() / 1000;

        PushFacade.getInstance().fablabDoorJustOpened(doorState);
        return Response.ok().build();
    }
}

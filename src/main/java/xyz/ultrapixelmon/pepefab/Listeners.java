package xyz.ultrapixelmon.pepefab;

import com.pixelmonmod.pixelmon.api.events.battles.TurnEndEvent;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;

public class Listeners {

    @SubscribeEvent
    public void onTurnEnd(TurnEndEvent event) { // Lorsque mon tour fini
        this.battleControllerAFK(event.bcb);
    }

    private void update (EntityPlayerMP player){
        player.setPositionAndUpdate(player.posX + 0, player.posY + 0.1, player.posZ + 0);
    }

    private void battleControllerAFK(BattleControllerBase bcb) {
        Iterator var2 = bcb.participants.iterator();

        while(var2.hasNext()) {
            BattleParticipant participant = (BattleParticipant)var2.next();
            if (participant instanceof PlayerParticipant) {
                this.update(((PlayerParticipant)participant).player);
            }
        }
    }
/*
    @SubscribeEvent
    public void useItemBattle(UseBattleItemEvent event){ // Lorsque les joueurs utilisent un item dans son sac
        if(event.user.getPlayerOwner() != null){

        } else if(event.target.getPlayerOwner() != null){

        }
    }

    @SubscribeEvent
    public void onAttackDamage(AttackEvents.DamageEvent event){
        if(event.user.getPlayerOwner() != null){ // Lorsque le pok?mon / joueur frappe un autre pok?mon

        } else if(event.target.getPlayerOwner() != null){ // Lorsque l'autre pok?mon / joueur me frappe

        }
    }
    @SubscribeEvent
        public void catchPokeStart(CaptureEvent.StartCapture event) { // D?but d'une capture de pok?mon
            this.battleControllerAFK(event.bcb);
        }
        @SubscribeEvent
        public void catchPokeFail(CaptureEvent.FailedCapture event) { // Capture de pok?mon ?choue
        }

        @SubscribeEvent
        public void catchPokeSuccess(CaptureEvent.SuccessfulCapture event) { // Capture de pok?mon r?ussite
        }
    */
}

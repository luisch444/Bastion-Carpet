# Bastion Carpet

## Bastion SMP

Bastion SMP is a technical and decorative minecraft server: [discord](https://discord.gg/x3bVAbQAZt)

## Rules

### Elder guardian Spawn on thunder [class](/src/main/java/carpet/bastion/mixin/OceanMonumentMixin.java)

> Use: /carpet {setdefault} elderguardianspawnonthunder true/false
>
> This option adds the spawn of Elder Guardians when it's Thundering.

### Disable Lighting-fire [class](/src/main/java/carpet/bastion/mixin/LightningEntityMixin.java)

> Use: /carpet {setdefault} disablelightingfire true/false
>
> This option cancels the fire when a lighting strikes.

### ZombifiedPiglin Drops EnchantedGoldenApple [class](/src/main/java/carpet/bastion/mixin/ZombifiedPiglinEntityMixin.java)

> Use: /carpet {setdefault} zombifiedpiglindropsgoldenapple true/false
>
> This option adds the drop of Enchanted Golden Apple with a very low probability to the Zombified Piglin.

### Players not whitelisted can't load new chunks. [class](/src/main/java/carpet/bastion/mixin/ThreadedAnvilChunkStorageMixin.java)

> Use: /carpet {setdefault} botsLoadChunks true/false
>
>  When this option is disabled, players that aren't on the whitelist can't load new chunks but maintain the current chunks loaded.

### It's Halloween!!! [class](/src/main/java/carpet/bastion/mixin/AbstractSkelettonEntityMixin.java)  [class](/src/main/java/carpet/bastion/mixin/ZombieEntityMixin.java)

> Use: /carpet {setdefault} isHalloween true/false
>
>  Set to true for mobs to have a chance to appear with carved pumpkin or Jack o'Lantern.

### Bats say UwU on Death [class](/src/main/java/carpet/bastion/mixin/BatEntityMixin.java)

> Use: /carpet {setdefault} batsSayUwUonDeath true/false
>
> Bats say UwU in the chat when dies

### Johan pto [class](/src/main/java/carpet/bastion/rules/timed/JohanPtoRule.java)

> Use: /carpet {setdefault} isJohanPto true/false
>
> Sends the message 'Johan pto' every 20 minutes

### Averroes Hosting Discount [class](/src/main/java/carpet/bastion/rules/timed/DescuentoRule.java)

> Use: /carpet {setdefault} discountTimedMessage true/false
>
> Sends the averroes hosting discount message every 20 minutes

### Enable signal command [use](/README.md#signal-class)

> Use: /carpet {setdefault} commandSignal true/false
>
> This option enables the signal command.

### Enable Alert command [use](/README.md#alert-class)

> Use: /carpet {setdefault} commandAlert true/false
>
> This option enables the alert command.

### Enable hostCommand command [use](/README.md#host-class)

> Use: /carpet {setdefault} hostCommand true/false
>
> This option enables Enables /host command.

### Enable ipCommand command [use](/README.md#ip-class)

> Use: /carpet {setdefault} ipCommand true/false
>
> This option enables Enables /ip command.

## Commands

### Signal [class](/src/main/java/carpet/bastion/command/CommandSignal.java)

> Use: /signal {signalStrength} {barrel}
>
> Parameters:
> - signalStrength: number between 1 and 897 (both included)
> - barrel: true/false
>
> 'signalStrengtth' Gives the player a container with an specific redstone signal.
> - If barrel is false:
    >  * If signal <= 3: Gives you a Cauldron.
>  * If signal >3 and <=8: Gives you a Composter.
>  * If signal > 8: Gives you a Barrel.
> - If barrel is true:
    >  * Gives you a Barrel with the specified signal.

### Alert [class](/src/main/java/carpet/bastion/command/HostCommand.java)

>* Use case1: /alert {playerName} "{message}"
> 
>Example: /alert all "Aba viejo" 
> 
> Case 1 : Send message to specific player
> 
> Case 2 : Send message to all players
> 

### Host [class](/src/main/java/carpet/bastion/command/AlertCommand.java)

>* Use: /host --> averroesHosting ofc
> 

### ip [class](/src/main/java/carpet/bastion/command/IPCommand.java)

>* Use: /ip --> bastion.com
> 

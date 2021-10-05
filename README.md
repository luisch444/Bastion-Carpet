# Bastion Carpet

## INFO

for this proyect I take as example TIS carpet, so if its have code very similar is becase that

## Bastion SMP

Bastion SMP is a technical and decorative minecraft server: [discord](https://discord.gg/x3bVAbQAZt)

## Rules

### Elderguardian Spawn on thunder [class](/src/main/java/carpet/bastion/mixin/OceanMonumentMixin.java)

  > Use: /carpet {setdefault} elderguardianspawnonthunder true/false
  >
  > This option add the spawn of Elder Guardians when is Thundering 

### Disable Lighting-fire [class](/src/main/java/carpet/bastion/mixin/LightningEntityMixin.java)

  > Use: /carpet {setdefault} disablelightingfire true/false
  >
  > This option cancel the fire when a lighting stroke

### ZombifiedPiglin Drops EnchantedGoldenApple [class](/src/main/java/carpet/bastion/mixin/ZombifiedPiglinEntityMixin.java)

  > Use: /carpet {setdefault} zombifiedpiglindropsgoldenapple true/false
  >
  > This option add to the ZombifiedPiglin the drop of EnchantedGoldenApple with very low probability

### Enable signal command

> Use: /carpet {setdefault} commandSignal true/false
>
> This option enable the signal command

## Commands

### Signal

> Use: /signal {signalStrength} {barrel}
>
> Parameters:
> - signalStrength: number between 1 and 897 (both included)
> - barrel: true/false
> 
> Give to player a container with signal specified with 'signalStrengtth'
> - If barrel is false: 
>  * If signal <= 3: Give you a Cauldron
>  * If signal >3 and <=8: Give you a Composter
>  * If signal > 8: Give you a Barrel
> - If barrel is true:
>  * Give you a Barrel
> 
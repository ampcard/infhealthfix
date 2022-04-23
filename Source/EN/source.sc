/*
    <title>
    Infinite Health Fix
    </title>

    <author>
        Miotto
    </author>

    <summary>
        Fixes the Infinite Health/BAGUVIX cheat so it resets player's health back to max whenever they lose health. This isn't an elegant solution at all.
        For some reason, the player's current health is an integer and their max health is a float.
    </summary>

    <changelog>
        23/04/22: 1.0 released.
    </changelog>
*/


SCRIPT_START
{
LVAR_INT bIsCheatOn scplayer iPlayerCurrentHealth iPlayerMaxHealth
LVAR_FLOAT fPlayerMaxHealth

GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
    WAIT 0
    GET_CHAR_MAX_HEALTH scplayer fPlayerMaxHealth // Gets player's max health.
    GET_CHAR_HEALTH scplayer iPlayerCurrentHealth // Gets player's current health.
    iPlayerMaxHealth =# fPlayerMaxHealth // Converts the player's max health to an integer.

    READ_MEMORY 0x96916D 1 FALSE bIsCheatOn // Checks if the Infinite Health cheat is on.
    IF bIsCheatOn = 1 // If the cheat is on...
        IF (iPlayerCurrentHealth < iPlayerMaxHealth) // And if the player's current health is less than their max health...
            SET_CHAR_HEALTH scplayer iPlayerMaxHealth // Resets the player's health back to its max value.
        ENDIF
    ENDIF
ENDWHILE

}
SCRIPT_END
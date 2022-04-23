/*
    <title>
    Infinite Health Fix
    </title>

    <author>
        Miotto
    </author>

    <summary>
        Corrige o cheat de vida infinita/BAGUVIX para que ele restaure a vida do player ao máximo sempre que ele toma dano. Não é uma solução elegante.
        Por algum motivo, a vida máxima é um float e a vida atual é um integer.
    </summary>

    <changelog>
        23/04/22: 1.0 lançado.
    </changelog>
*/


SCRIPT_START
{
LVAR_INT bIsCheatOn scplayer iPlayerCurrentHealth iPlayerMaxHealth
LVAR_FLOAT fPlayerMaxHealth

GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
    WAIT 0
    GET_CHAR_MAX_HEALTH scplayer fPlayerMaxHealth // Pega a vida máxima do player.
    GET_CHAR_HEALTH scplayer iPlayerCurrentHealth // Pega a vida atual do player.
    iPlayerMaxHealth =# fPlayerMaxHealth // Converte a vida máxima a um integer.

    READ_MEMORY 0x96916D 1 FALSE bIsCheatOn // Checa se o cheat de Vida Infinita tá on.
    IF bIsCheatOn = 1 // Caso estiver...
        IF (iPlayerCurrentHealth < iPlayerMaxHealth) // E a vida atual do player for menor que a vida máxima dele...
            SET_CHAR_HEALTH scplayer iPlayerMaxHealth // Restaura a vida atual do player à vida máxima do mesmo.
        ENDIF
    ENDIF
ENDWHILE

}
SCRIPT_END
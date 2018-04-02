DROP PROCEDURE IF EXISTS `GetDevCreditsData` $$

CREATE  PROCEDURE `GetDevCreditsData`()
BEGIN

SELECT * FROM devcredits;

END $$


DROP PROCEDURE IF EXISTS `GetSandBoxData` $$

CREATE  PROCEDURE `GetSandBoxData`()
BEGIN

  SELECT * FROM treeelements;
  SELECT *
  FROM accordians
  WHERE panelId IN (SELECT panelId FROM panels WHERE panelName = "LEFT") order by orderList DESC;

  SELECT *
  FROM accordians
  WHERE panelId IN (SELECT panelId FROM panels WHERE panelName = "RIGHT") order by orderList DESC;

  SELECT * FROM panels;




END $$

DROP PROCEDURE IF EXISTS `GetUserSandBoxData` $$

CREATE  PROCEDURE `GetUserSandBoxData`(IN userid VARCHAR(20))
BEGIN

  SELECT ele.eleId, eleName, ele.accdId, rootId, subEle, orderList
  FROM TreeElements ele, UserAccordianMapper accd , UserTreeMapper user
  WHERE ele.accdId = accd.accdId
  AND ele.eleId = user.eleId
  AND user.userId = userid;

  SELECT accd.accdId, accdName, panelId, orderList
  FROM Accordians accd, UserAccordianMapper user
  WHERE accd.accdId = user.accdId
  AND user.userId = userid
  AND panleId IN (SELECT panelId FROM Panels WHERE panelName = "LEFT");

  SELECT accd.accdId, accdName, panelId, orderList
  FROM Accordians accd, UserAccordianMapper user
  WHERE accd.accdId = user.accdId
  AND user.userId = userid
  AND panelId IN (SELECT panelId FROM Panels WHERE panelName = "RIGHT");

END $$
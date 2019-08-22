<?php
if (isset($_SESSION['username']) || !isset($_SESSION['quant'])) {
  $_SESSION['quant'] = 4;
}
?>
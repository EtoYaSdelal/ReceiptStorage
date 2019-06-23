let $form = document.getElementById('newBill'),
    $submitBtn = document.getElementById('submit');
$submitBtn.addEventListener('click', function () {
    if ($form.checkValidity()) {
        $form.submit();
    } else {
        document.getElementById("companyName").value = "Unknown";
        document.getElementById("payment").value = 0.0;
        document.getElementById("paid").value = false;
    }
});



// For now, we'll just simulate fetching counts
document.addEventListener("DOMContentLoaded", () => {
    // Dummy counts
    const residentsCount = 12;
    const medicationsCount = 48;
    const countSheetsCount = 5;

    document.getElementById("residents-count").innerText = residentsCount;
    document.getElementById("medications-count").innerText = medicationsCount;
    document.getElementById("count-sheets-count").innerText = countSheetsCount;
});
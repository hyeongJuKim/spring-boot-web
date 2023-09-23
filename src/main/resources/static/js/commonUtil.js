var commonUtil = (function () {

    return {
        isNotEmpty: function isNotEmpty(value) {
            return value !== undefined && value !== null && value !== "";
        }
    }
})();

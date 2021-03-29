
/**
 *
 * Created with NetBeans IDE
 *
 * Code     : Icon Select J
 * Version  : 1.0
 *
 * User     : Bugra OZDEN
 * Site     : http://www.bugraozden.com
 * Mail     : bugra.ozden@gmail.com
 *
 * Date     : 10/30/13
 * Time     : 01:10 PM
 *
 */

IconSelect.DEFAULT = {};
IconSelect.DEFAULT.SELECTED_ICON_WIDTH = 48;
IconSelect.DEFAULT.SELECTED_ICON_HEIGHT = 48;
IconSelect.DEFAULT.SELECTED_BOX_PADDING = 1;
IconSelect.DEFAULT.SELECTED_BOX_PADDING_RIGHT = 12;
IconSelect.DEFAULT.ICONS_WIDTH = 32;
IconSelect.DEFAULT.ICONS_HEIGHT = 32;
IconSelect.DEFAULT.BOX_ICON_SPACE = 1;
IconSelect.DEFAULT.HORIZONTAL_ICON_NUMBER = 3;
IconSelect.DEFAULT.VECTORAL_ICON_NUMBER = 3;
IconSelect.DEFAULT.COMPONENT_ICON_FILE_PATH = "images/control/icon-select/arrow.png";

function IconSelect($$elementID, $$parameters) {

    var _icons = [];
    var _selectedIndex = -1;
    var _boxScroll;

    var _default = IconSelect.DEFAULT;

    function _init() {

        //parametreler boş gelirse
        if (!$$parameters)
            $$parameters = {};
        //En üst elementi seç
        if (_View.setIconSelectElement($$elementID)) {

            //set parameters
            $$parameters = _Model.checkParameters($$parameters);
            //create UI
            var ui = _View.createUI($$parameters, $$elementID);
            //basıldığında göster/gizle
            _View.iconSelectElement.onclick = function() {
                _View.showBox();
            };

            //Başlangıçta gizle
            _View.showBox(false);

            //Nesneye basıldığında gizlemeyi iptal et.
            _View.iconSelectElement.addEventListener('click', function($event) {
                $event.stopPropagation();
            });

            //dışarı basıldığında gizle.
            window.addEventListener('click', function() {
                _View.showBox(false);
            });

        } else {
            alert("Element not found.");
        }

    }

    //Tüm iconları yeniden yükle.
    this.refresh = function($icons) {

        _icons = [];

        var setSelectedIndex = this.setSelectedIndex;

        for (var i = 0; i < $icons.length; i++) {
            $icons[i].element = _View.createIcon($icons[i].iconFilePath, $icons[i].iconValue, i, $icons[i].iconText, $$parameters);
            $icons[i].element.onclick = function() {
                setSelectedIndex(this.childNodes[0].getAttribute('icon-index'));

            };
            _icons.push($icons[i]);

        }

        var horizontalIconNumber = Math.round(($icons.length) / $$parameters.vectoralIconNumber);

        _View.boxElement.setAttribute("style", "height:" + (((($$parameters.iconsHeight + 2) * horizontalIconNumber) +
                ((horizontalIconNumber + 1) * $$parameters.boxIconSpace)) + (40 * (Math.abs(horizontalIconNumber)))) + "px;");
        // _View.boxElement.style.height = ((($$parameters.iconsHeight + 2) * horizontalIconNumber) +
        //         ((horizontalIconNumber + 1) * $$parameters.boxIconSpace)) + (40 * (Math.abs(horizontalIconNumber)));
        this.setSelectedIndex(0);

    };

    //icon listesini al.
    this.getIcons = function() {
        return _icons;
    };

    //iconu seçili hale gelir.
    this.setSelectedIndex = function($index) {

        var icon;

        if (_icons.length > $index)
            icon = _icons[$index];

        if (icon) {
            //eski icondan seçilme özelliğini kaldır.
            if (_selectedIndex !== -1)
                _icons[_selectedIndex].element.setAttribute('class', 'icon');
            _selectedIndex = $index;
            _View.selectedIconImgElement.setAttribute('src', icon.iconFilePath);
            _View.selectedIconImgElement.setAttribute('title', icon.iconFilePath);
            _View.selectedTextImgElement.innerHTML = icon.iconText;
            if (_selectedIndex !== -1)
                _icons[_selectedIndex].element.setAttribute('class', 'icon selected');
            //set the hidden field value
            if (icon.iconText !== "Select a theme") {
                setTheme(icon.iconText);                                
            } 
        }

        _View.iconSelectElement.dispatchEvent(new Event('changed'));

        //_View.showBox(false);        
    };

    this.getSelectedIndex = function() {
        return _selectedIndex;
    };
    this.getSelectedValue = function() {
        return _icons[_selectedIndex].iconValue;
    };
    this.getSelectedFilePath = function() {
        return _icons[_selectedIndex].iconFilePath;
    };



    //### VIEW CLASS ###

    function _View() {
    }

    _View.iconSelectElement;
    _View.boxElement;
    _View.boxScrollElement;
    _View.selectedIconImgElement;
    _View.selectedIconElement;

    _View.showBox = function($isShown) {

        if ($isShown == null) {
            $isShown = (_View.boxElement.style.display === "none") ? true : false;
        }

        if ($isShown) {
            _View.boxElement.style.display = "block";
            _View.boxScrollElement.style.display = "block";

            _boxScroll = (_boxScroll) ? _boxScroll : new iScroll($$elementID + "-box-scroll");
        } else {
            _View.boxElement.style.display = "none";
            _View.boxScrollElement.style.display = "none";
        }

        _View.boxElement.style.display = ($isShown) ? "block" : "none";
    };

    _View.setIconSelectElement = function($elementID) {
        _View.iconSelectElement = document.getElementById($elementID);
        return _View.iconSelectElement;
    };

    _View.clearUI = function() {
        _View.iconSelectElement.innerHTML = "";
    };

    _View.clearIcons = function() {
        _View.boxElement.innerHTML = "";
    };

    _View.createUI = function($parameters) {

        /* HTML MODEL
         
         <div id="my-icon-select" class="icon-select">
         <div class="selected-box">
         <div class="selected-icon"><img src="images/icons/i2.png"></div>
         <div class="component-icon"><img src="images/control/icon-select/arrow.png"></div>
         <div class="box">
         <div class="icon"><img src="images/icons/i1.png"></div>
         <div class="icon selected"><img src="images/icons/i2.png"></div>
         <div class="icon"><img src="images/icons/i3.png"></div>
         <div class="icon"><img src="images/icons/i4.png"></div>
         <div class="icon"><img src="images/icons/i3.png"></div>
         <div class="icon"><img src="images/icons/i4.png"></div>
         <div class="icon"><img src="images/icons/i5.png"></div>
         <div class="icon"><img src="images/icons/i6.png"></div>
         <div class="icon"><img src="images/icons/i7.png"></div>
         <div class="icon"><img src="images/icons/i8.png"></div>
         </div>
         </div>
         </div>
         
         */

        _View.clearUI();

        _View.iconSelectElement.setAttribute('class', 'icon-select');

        var selectedBoxElement = document.createElement('div');
        selectedBoxElement.setAttribute('class', 'selected-box');

        var selectedIconElement = document.createElement('div');
        selectedIconElement.setAttribute('class', 'selected-icon');

        _View.selectedIconImgElement = document.createElement('img');
        _View.selectedIconImgElement.setAttribute('src', '');
        _View.selectedTextImgElement = document.createElement('div');
        _View.selectedTextImgElement.setAttribute("style", "width:250px;padding-left:5px;");
        _View.selectedTextImgElement.innerHTML = '';
        _View.selectedConfirmImgElement = document.createElement('div');
        _View.selectedConfirmImgElement.setAttribute("style", "color:#cccccc;width:250px;padding-left:5px;padding-top:68px;");
        _View.selectedConfirmImgElement.innerHTML = "<strong>"+currentTheme+"</strong>";
        selectedIconElement.appendChild(_View.selectedIconImgElement);

        var componentIconElement = document.createElement('div');
        componentIconElement.setAttribute('class', 'component-icon');

        var componentIconImgElement = document.createElement('img');
        componentIconImgElement.setAttribute('src', $parameters.componentIconFilePath);
        componentIconElement.appendChild(componentIconImgElement);

        _View.boxScrollElement = document.createElement('div');
        _View.boxScrollElement.setAttribute('id', $$elementID + "-box-scroll");
        _View.boxScrollElement.setAttribute('class', 'box');

        _View.boxElement = document.createElement('div');

        //_View.boxElement.setAttribute('class', 'box');
        _View.boxScrollElement.appendChild(_View.boxElement);

        _View.selectedIconImgElement.setAttribute('width', $parameters.selectedIconWidth);
        _View.selectedIconImgElement.setAttribute('height', $parameters.selectedIconHeight);
        selectedIconElement.setAttribute("style", "width:" + $parameters.selectedIconWidth + "px;height:" + $parameters.selectedIconHeight + "px;top:" + $parameters.selectedBoxPadding + "px;left:" + $parameters.selectedBoxPadding + "px;");
        //selectedIconElement.style.width = $parameters.selectedIconWidth;
        //selectedIconElement.style.height = $parameters.selectedIconHeight;
        //selectedIconElement.style.top = $parameters.selectedBoxPadding;
        //selectedIconElement.style.left = $parameters.selectedBoxPadding;

        selectedBoxElement.setAttribute("style", "width:" + ($parameters.selectedIconWidth + $parameters.selectedBoxPadding + $parameters.selectedBoxPaddingRight) + "px;height:" + ($parameters.selectedIconHeight + ($parameters.selectedBoxPadding * 2)) + "px;");
        //selectedBoxElement.style.width = $parameters.selectedIconWidth + $parameters.selectedBoxPadding + $parameters.selectedBoxPaddingRight;
        //selectedBoxElement.style.height = $parameters.selectedIconHeight + ($parameters.selectedBoxPadding * 2);

        componentIconElement.setAttribute("style", "bottom:" + (4 + $parameters.selectedBoxPadding) + "px;");
        //componentIconElement.style.bottom = 4 + $parameters.selectedBoxPadding;
        _View.boxScrollElement.setAttribute("style", "left:" + (parseInt(selectedBoxElement.style.width) + 1) + "px;width:" + (((($parameters.iconsWidth + 2 + 40) * $parameters.vectoralIconNumber) +
                (($parameters.vectoralIconNumber + 1) * ($parameters.boxIconSpace)))) + "px;height:" + ((((($parameters.iconsHeight + 2) * $parameters.horizontalIconNumber) +
                (($parameters.horizontalIconNumber + 1) * ($parameters.boxIconSpace)))) + (40 * $parameters.horizontalIconNumber)) + "px;");

        //_View.boxScrollElement.style.left = parseInt(selectedBoxElement.style.width) + 1;
        //_View.boxScrollElement.style.width = ((($parameters.iconsWidth + 2 + 40) * $parameters.vectoralIconNumber) +
        //        (($parameters.vectoralIconNumber + 1) * ($parameters.boxIconSpace)));
        //_View.boxScrollElement.style.height = (((($parameters.iconsHeight + 2) * $parameters.horizontalIconNumber) +
        //        (($parameters.horizontalIconNumber + 1) * ($parameters.boxIconSpace)))) + (40 * $parameters.horizontalIconNumber);

        _View.boxElement.setAttribute("style", "left:" + _View.boxScrollElement.style.left + "px;width:" + _View.boxScrollElement.style.width + "px;");
        //_View.boxElement.style.left = _View.boxScrollElement.style.left;
        //_View.boxElement.style.width = _View.boxScrollElement.style.width;

        _View.iconSelectElement.appendChild(selectedBoxElement);
        selectedBoxElement.appendChild(_View.selectedTextImgElement);
        selectedBoxElement.appendChild(selectedIconElement);   
        selectedBoxElement.appendChild(_View.selectedConfirmImgElement);
        selectedBoxElement.appendChild(componentIconElement);
        selectedBoxElement.appendChild(_View.boxScrollElement);        


        var results = {};
        results['iconSelectElement'] = _View.iconSelectElement;
        results['selectedBoxElement'] = selectedBoxElement;
        results['selectedIconElement'] = selectedIconElement;
        results['selectedIconImgElement'] = _View.selectedIconImgElement;
        results['componentIconElement'] = componentIconElement;
        results['componentIconImgElement'] = componentIconImgElement;

        return results;


        //trigger: created ( run setValues )

    };

    _View.createIcon = function($iconFilePath, $iconValue, $index, $iconText, $parameters) {

        /* HTML MODEL 
         
         <div class="icon"><img src="images/icons/i1.png"></div>
         
         */
        
        var iconElement = document.createElement('div');
        if ($iconText !== "Select a theme") {
            iconElement.setAttribute('class', 'icon');
            //iconElement.style.width = $parameters.iconsWidth + 40;
            //iconElement.style.height = $parameters.iconsHeight + 40;
            //iconElement.style.marginLeft = $parameters.boxIconSpace;
            //iconElement.style.marginTop = $parameters.boxIconSpace;
            iconElement.setAttribute("style", "width:" + ($parameters.iconsWidth + 40) + "px;height:" + ($parameters.iconsHeight + 40) + "px;margin-left:" + $parameters.boxIconSpace + "px;margin-top:" + $parameters.boxIconSpace + "px;");

            var iconImgElement = document.createElement('img');
            iconImgElement.setAttribute('src', $iconFilePath);
            iconImgElement.setAttribute('icon-value', $iconValue);
            iconImgElement.setAttribute('icon-index', $index);
            iconImgElement.setAttribute('width', $parameters.iconsWidth);
            iconImgElement.setAttribute('height', $parameters.iconsHeight);
            iconImgElement.setAttribute('style', 'padding-left:20px;padding-top:20px;');

            var iconTextElement = document.createElement('div');
            iconTextElement.setAttribute('icon-index', $index);
            iconTextElement.setAttribute('style', 'padding-left:5px;');
            iconTextElement.innerHTML = $iconText;

            iconElement.appendChild(iconTextElement);
            iconElement.appendChild(iconImgElement);
            _View.boxElement.appendChild(iconElement);

        }
        return iconElement;
    };

    //### MODEL CLASS ###

    function _Model() {
    }

    //TODO: params değişkenini kaldır yeni oluştursun.
    _Model.checkParameters = function($parameters) {

        $parameters.selectedIconWidth = ($parameters.selectedIconWidth) ? $parameters.selectedIconWidth : _default.SELECTED_ICON_WIDTH;
        $parameters.selectedIconHeight = ($parameters.selectedIconHeight) ? $parameters.selectedIconHeight : _default.SELECTED_ICON_HEIGHT;
        $parameters.selectedBoxPadding = ($parameters.selectedBoxPadding) ? $parameters.selectedBoxPadding : _default.SELECTED_BOX_PADDING;
        $parameters.selectedBoxPaddingRight = ($parameters.selectedBoxPaddingRight) ? $parameters.selectedBoxPaddingRight : _default.SELECTED_BOX_PADDING_RIGHT;
        $parameters.iconsWidth = ($parameters.iconsWidth) ? $parameters.iconsWidth : _default.ICONS_WIDTH;
        $parameters.iconsHeight = ($parameters.iconsHeight) ? $parameters.iconsHeight : _default.ICONS_HEIGHT;
        $parameters.boxIconSpace = ($parameters.boxIconSpace) ? $parameters.boxIconSpace : _default.BOX_ICON_SPACE;
        $parameters.vectoralIconNumber = ($parameters.vectoralIconNumber) ? $parameters.vectoralIconNumber : _default.VECTORAL_ICON_NUMBER;
        $parameters.horizontalIconNumber = ($parameters.horizontalIconNumber) ? $parameters.horizontalIconNumber : _default.HORIZONTAL_ICON_NUMBER;
        $parameters.componentIconFilePath = ($parameters.componentIconFilePath) ? $parameters.componentIconFilePath : _default.COMPONENT_ICON_FILE_PATH;

        return $parameters;

    };

    _init();

}
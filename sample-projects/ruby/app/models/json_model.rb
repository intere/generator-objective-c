
#
#  json_model.rb
#
#  Released with JSON Model Generator 0.0.4 on Fri Mar 20 08:22:20 MDT 2015
#    https://github.com/intere/generator-json-models
#
#    The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
#
#
class JsonModel
  def initialize(init_json)
    if init_json.class == String
      @json = JSON.parse(init_json)
    else
      @json = init_json
    end    
    @json.symbolize_keys!
  end

  def json
    @json
  end
end
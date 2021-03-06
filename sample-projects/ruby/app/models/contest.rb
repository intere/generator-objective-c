#
# contest.rb
#
# Generated by JSON Model Generator v0.0.5 on Aug 28, 2016
# https://github.com/intere/generator-json-models
#
# The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
#

class Contest

    def created_date
        @created_date ||= json.try(:[], :createdDate)
    end

    def description
        @description ||= json.try(:[], :description)
    end

    def end_date
        @end_date ||= json.try(:[], :endDate)
    end

    def id
        @id ||= json.try(:[], :id)
    end

    def image_url
        @image_url ||= json.try(:[], :imageUrl)
    end

    def latitude
        @latitude ||= json.try(:[], :latitude)
    end

    def longitude
        @longitude ||= json.try(:[], :longitude)
    end

    def purse_description
        @purse_description ||= json.try(:[], :purseDescription)
    end

    def purse_image_url
        @purse_image_url ||= json.try(:[], :purseImageUrl)
    end

    def purse_prize_value
        @purse_prize_value ||= json.try(:[], :pursePrizeValue)
    end

    def purse_title
        @purse_title ||= json.try(:[], :purseTitle)
    end

    def purse_type
        @purse_type ||= json.try(:[], :purseType)
    end

    def results
        @results ||= json.try(:[], :results).map {|o| ContestResults.new(o)}
    end

    def runner_up_description
        @runner_up_description ||= json.try(:[], :runnerUpDescription)
    end

    def runner_up_prize_value
        @runner_up_prize_value ||= json.try(:[], :runnerUpPrizeValue)
    end

    def runner_up_purse_image_url
        @runner_up_purse_image_url ||= json.try(:[], :runnerUpPurseImageUrl)
    end

    def runner_up_title
        @runner_up_title ||= json.try(:[], :runnerUpTitle)
    end

    def scored
        @scored ||= json.try(:[], :scored)
    end

    def size
        @size ||= json.try(:[], :size)
    end

    def sponsor
        @sponsor ||= ContestSponsor.new json.try(:[], :sponsor)
    end

    def start_date
        @start_date ||= json.try(:[], :startDate)
    end

    def state
        @state ||= json.try(:[], :state)
    end

    def state_name
        @state_name ||= json.try(:[], :stateName)
    end

    def title
        @title ||= json.try(:[], :title)
    end

    def track_ids
        @track_ids ||= json.try(:[], :trackIDs)
    end

    def type
        @type ||= json.try(:[], :type)
    end

    def type_name
        @type_name ||= json.try(:[], :typeName)
    end

    def user_ids
        @user_ids ||= json.try(:[], :userIDs)
    end


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
